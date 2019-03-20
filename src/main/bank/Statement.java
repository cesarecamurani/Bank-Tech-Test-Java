//package bank;
//
//import java.util.List;
//import java.util.Map;
//import java.text.SimpleDateFormat;
//
//class Statement{
//
//    String header = "Date || Credit || Debit || Balance\n";
//    //    String formatDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
//
//
//    Statement(String header){
//        this.header = header;
//    }
//
//    String format(List<Map<String, String>> transactions){
//        for (int i = 0 ; i < transactions.size() ; i++) {
//            Map<String, String> transaction = transactions.get(i);
//            for (Map.Entry<String, String> entry : transaction.entrySet()) {
//                System.out.println(this.header += "Value = " + entry.getValue());
//            }
//        }
//        return this.header;
//
//    }
//
//    String display(List<Map<String, String>> transactions){
//        return format(transactions);
//    }
//
//}