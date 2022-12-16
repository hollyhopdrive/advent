package day15.solutions.sensors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import shared.Coordinate;

@RequiredArgsConstructor
public class RowEncoding {

    @Getter
    //private final int rowIndex;
    
    // Beacons in this row
    private final Set<Coordinate> beacons = new HashSet<>();
    
    private List<RunLengthEncoding> runLengths = new ArrayList<>();
    
    public void merge(RunLengthEncoding rle) {
        runLengths.add(rle);
        Collections.sort(runLengths, new RunLengthEncodingComparator());
        compact();
    }
    
    public void addBeacon(Coordinate beacon) {
        beacons.add(beacon);
    }
    
    public int count() {
        
        // Split the run lengths if there are any beacons
        beacons.forEach(b -> split(b.getX()));
        
        //System.out.println("Counting after beacon split:\n" + toString());
        
        int count = 0;
        for(RunLengthEncoding rle : runLengths) {
            //System.out.println("RLE " + rle + " has count " + rle.getEnd() + " - " + rle.getStart() + " = " + (rle.getEnd() - rle.getStart()));
            count += rle.getEnd() - rle.getStart() + 1;
            
        }
        return count;
        //return count = count + (runLengths.size() - 1);
    }
    
    private void compact() {
        List<RunLengthEncoding> toRemove = new ArrayList<>();
        List<RunLengthEncoding> toAdd = new ArrayList<>();
        
        for(int i = 0; i < runLengths.size() - 1; ++i) {
            RunLengthEncoding lhs = runLengths.get(i);
            RunLengthEncoding rhs = runLengths.get(i+1);
            RunLengthEncoding merged = merge(lhs, rhs);
            if(merged != null) {
                toRemove.add(lhs);
                toRemove.add(rhs);
                toAdd.add(merged);
                break;
            }
        }
    
        if(toRemove.isEmpty() && toAdd.isEmpty()) {
            return;
        }
        
        runLengths.removeAll(toRemove);
        toRemove.clear();
        
        runLengths.addAll(toAdd);
        toAdd.clear();
        
        Collections.sort(runLengths, new RunLengthEncodingComparator());
        
        compact();
    }
    
    private RunLengthEncoding merge(final RunLengthEncoding lhs, final RunLengthEncoding rhs) {

        if(lhs.contains(rhs)) {
            return lhs;
        }
        if(rhs.contains(lhs)) {
            return rhs;
        }
        if(lhs.overlaps(rhs) || rhs.overlaps(lhs)) {
            return new RunLengthEncoding(Math.min(lhs.getStart(), rhs.getStart()), Math.max(lhs.getEnd(), rhs.getEnd()));
        }
        
        return null;
    }
    
    private void split(final int value) {
        List<RunLengthEncoding> toAdd = new ArrayList<RunLengthEncoding>();
        List<RunLengthEncoding> toRemove = new ArrayList<RunLengthEncoding>();
        
        runLengths.forEach(rl -> {
            if(rl.contains(value)) {
                toRemove.add(rl);
                toAdd.addAll(rl.split(value));
            }
        });
        
        runLengths.removeAll(toRemove);
        runLengths.addAll(toAdd);
    }
    
    public RowEncoding invert(int lowerBound, int upperBound) {
        
        //System.out.println("Inverting\n" + this + "with max bounds " + lowerBound + " --> " + upperBound);
        // Build a RLE contaning the entire range
        RowEncoding inverted = new RowEncoding();
        RunLengthEncoding rle = new RunLengthEncoding(lowerBound, upperBound);
        inverted.merge(rle);
        
        // Then remove each RLE from it 
        runLengths.forEach(rl -> {
            inverted.remove(rl);
        });
        
        //System.out.println("Inverted to:\n" + this);
        return inverted;
        
        
    }
    
    public int getStart() {
        if(runLengths.isEmpty()) {
            return 0;
        }
        return runLengths.get(0).getStart();
    }
    
    public void remove(RunLengthEncoding rangeToRemove) {
        
        List<RunLengthEncoding> toAdd = new ArrayList<>();
        List<RunLengthEncoding> toRemove = new ArrayList<>();
        
        for(RunLengthEncoding rl : runLengths) {
            
            if(rl.contains(rangeToRemove)) { 
                toRemove.add(rl);
                toAdd.add(new RunLengthEncoding(rl.getStart(), rangeToRemove.getStart() - 1));
                toAdd.add(new RunLengthEncoding(rangeToRemove.getEnd() + 1, rl.getEnd()));
            } else if(rangeToRemove.contains(rl)) {
                toRemove.add(rl);
            } else if(rangeToRemove.overlaps(rl)) {
                toRemove.add(rl);
                if(rl.getStart() > rangeToRemove.getStart())  {
            
                    // Overlap on the left
                    toAdd.add(new RunLengthEncoding(rangeToRemove.getEnd() + 1, rl.getEnd()));
                } else {
                    // Overlap on the right
                    toAdd.add(new RunLengthEncoding(rl.getStart(), rangeToRemove.getStart() - 1));
                }
           } 
        }
        
        runLengths.removeAll(toRemove);
        runLengths.addAll(toAdd);
    }
    
    
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        runLengths.forEach(rl -> sb.append(rl + "\n"));
        return sb.toString();
    }
    
}
