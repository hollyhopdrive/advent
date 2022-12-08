package day03.packing;

public class BadgePrioritizationAction extends PrioritizationAction {

    private static final int GROUP_SIZE = 3;
    
    @Override
    public Integer process(BackPack backpack) {
        
        if(addItemProvider(new FullPackAccessor(backpack)) == GROUP_SIZE) {
            return super.perform();
        }        
        return 0;
    }
}
