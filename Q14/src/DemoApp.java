

import service.RecruitmentManager;

public class DemoApp {

    public static void main(String[] args) {
        RecruitmentManager recruitmentManager = new RecruitmentManager();
        while (true) {
            recruitmentManager.menu();
        }
    }
}
