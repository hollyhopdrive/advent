package day15.solutions;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import day15.solutions.sensors.RowEncoding;
import day15.solutions.sensors.RunLengthEncoding;
import shared.Coordinate;
import shared.CoordinateMath;
import shared.Counter;
import shared.InputReader;
import shared.IntegerReader;

public class Runner {

    public static int runPart1(final String path, int rowIndex) {
        final List<String> input = new InputReader().readInputFile(path);
        
        final List<List<Coordinate>> sensorBeaconPairs = new ArrayList<>();
        input.forEach(l -> sensorBeaconPairs.add(IntegerReader.readCoordinates(l)));

        RowEncoding rowEncoding = new RowEncoding();
        sensorBeaconPairs.forEach(sb -> process(sb.get(0), sb.get(1), rowEncoding, rowIndex));
        return rowEncoding.count();
    }
    
    public static BigInteger runPart2(final String path, int maxX) {
        final List<String> input = new InputReader().readInputFile(path);
        
        final List<List<Coordinate>> sensorBeaconPairs = new ArrayList<>();
        input.forEach(l -> sensorBeaconPairs.add(IntegerReader.readCoordinates(l)));
        
        Counter i = new Counter();
        for(; i.getValue() < maxX; i.increment()) {
            RowEncoding rowEncoding = new RowEncoding();
            sensorBeaconPairs.forEach(sb -> process(sb.get(0), sb.get(1), rowEncoding, i.getValue()));
            RowEncoding inverted = rowEncoding.invert(0, maxX);
            
            if(inverted.count() != 0) {
                System.out.println("Found some non-zero range: " + inverted);
            }
            if(inverted.count() == 1) {
                System.out.println("Found it!!: " + inverted);
                
                BigInteger multiple = BigInteger.valueOf(inverted.getStart()).multiply(BigInteger.valueOf(4000000));
                BigInteger result = multiple.add(BigInteger.valueOf(i.getValue()));
                return result;
            }
            
        }
        
        return BigInteger.ZERO;
        
    }
    
    static void process(final Coordinate sensor, final Coordinate beacon, final RowEncoding row, final int rowIndex) {
                
        if(beacon.getY() == rowIndex) {
            row.addBeacon(beacon);
        }
        
        int distance = CoordinateMath.distance(sensor,  beacon);
        
        int fixedY = Math.abs(sensor.getY() - rowIndex);
        if(fixedY > distance) {
            // This sensor has no info about the significant row
            //System.out.println("\t--> This is greater than the distance, so this sensor has no info about row " + row.getRowIndex() + ". Discarding.\n\n");
            return;
        }

        int startX = sensor.getX() - (distance - fixedY);
        int endX = sensor.getX() + (distance - fixedY);
        row.merge(new RunLengthEncoding(startX, endX));
    }
}
