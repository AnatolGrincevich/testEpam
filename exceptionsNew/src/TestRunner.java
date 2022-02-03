
import services.PurchaseList;
import services.PurchasesFactory;


public class TestRunner {

    public static void main(String[] args) {
        PurchaseList purchaseList = new PurchaseList("src/in.csv");
        for (int i =0; i <purchaseList.size(); i++) {
            System.out.println(purchaseList.getPurchaseList().get(i));
        }
        System.out.println(PurchasesFactory.DISCOUNT_PURCHASE_FIELDS_NUMBER + PurchasesFactory.PURCHASE_FIELDS_NUMBER);
    }
}
