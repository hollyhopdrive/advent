package day03.solutions.packing;

public class ReorgPrioritizationAction extends PrioritizationAction {
    
    @Override
    public Integer process(final BackPack backpack) {

        addItemProvider(new CompartmentAccessor(backpack, true));
        addItemProvider(new CompartmentAccessor(backpack, false));
        
        return perform();
    }
}
