import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        /*存储玩家选择界面的指令*/
        int seleview;

        boolean begi = true;

        /*存储玩家的骰子点数以及玩家所选择的飞机*/
        int step;
        int step_plane;

        /*实例化对象*/
        View v = new View();
        Maps m = new Maps();
        Service s = new Service();

        /*循环接收玩家的操作*/
        while (begi){
            v.initFace();
            System.out.println("请键入即将进入界面的编号：");
        seleview = s.judgAct();
        switch (seleview) {
        /*游戏界面的操作*/
            case 1:
                v.initGameFace(m);
                while (begi) {
                    step = s.playerAct(m);
                    System.out.println("请" + (((m.flag + 1) % 2) + 1) + "号玩家选择将要移动的飞机：");
                    step_plane = s.selePlane(m);
                    if (s.checkWhere(step_plane,m) == 1){
                        if (s.judgeLegal(step)){
                            s.flyPlane(step_plane,m);
                            v.initGameFace(m);
                        }else {
                            if (s.judgFull(m)){
                            }
                        }
                    }else {
                        s.isWin(step,step_plane,m,v);
                        v.initGameFace(m);
                    }
                m.flag +=1;
                }
                break;

            /*玩法介绍界面的操作*/
            case 2:
                v.introductionFace();
                System.out.println("返回初始界面请键入0。");
                seleview = new Scanner(System.in).nextInt();
                break;

            /*排行榜界面的操作*/
            case 3:
                v.rankingFace();
                System.out.println("返回初始界面请键入0。");
                seleview = new Scanner(System.in).nextInt();
                break;

            /*其他操作则会退出程序*/
            default:
                System.exit(0);
                break;
        }
        }
    }
}

