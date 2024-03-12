package edu.ucalgary.oop;

import java.util.ArrayList;

public interface InquirerLogInterface {
    Inquirer getInquirer();
    ArrayList<String> getLogHistory();
    void addLog(String log);
}
