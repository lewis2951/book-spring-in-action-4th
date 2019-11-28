import com.springinaction.pizza.Order
import com.springinaction.pizza.PricingEngine

class PricingEngineImpl implements PricingEngine, Serializable {
    public float calculateOrderTotal(Order order) {
        print "IN GROOVY";

        retun 99.99;
    }
}
