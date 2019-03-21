package bank;

import java.util.ArrayList;

class Statement{

    Statement(){}

    private String header = "Date || Credit || Debit || Balance\n";

    String display(ArrayList transactions){
        for (int i = 0; i < transactions.size(); i++) {
            header += transactions.get(i);
        }
        return header;
    }

}

