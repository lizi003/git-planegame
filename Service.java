import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Service {
/*
    *参数：void；
    *返回值：int
    *功能：接收玩家键入的指令，并判断玩家的指令是否合法（eg，要求玩家输入1来进行xxx操作，输入2进行xxx操作、输入3进行xxx操作，
但玩家输入了5，就得提示玩家并让玩家重新输入）
*/
    int judgAct(){
        boolean f = true;//用于判断是否能结束输入循环 如果输入正确 flag = false;
        int num2 = 0;//用于最后的返回
        while(f) {//用于判断结束输入的循环
                System.out.println("请输入一个1-4的整数：");
                int num = new Scanner(System.in).nextInt();//输入
                if (num >= 1 && num <= 4) {
                    System.out.println("合法操作！");
                    f = false;
                    num2 = num;
                } else {
                    System.out.println("输入的数只能为1-4的整数,请重新输入！");
                }
            }
        return num2;
    }

/*
*   参数：class（地图m）
*   返回值：int
*   当玩家键入1后，投掷骰子（即生成1~6的随机数），将该随机数返回
*   当玩家键入2后，玩家即可自己设定当前回合的骰子点数，返回玩家设定的骰子点数
*   判断玩家键入的操作是否合法
* */
    int playerAct(Maps m) {
        int num = 1;
        int act = 1;
        boolean f = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请" + (((m.flag + 1) % 2) + 1) + "号玩家行动(输入1掷骰子):");
        while (f){
            int che = scanner.nextInt();
            if (che >= 1 && che <= 2){
                System.out.println("合法操作！");
                f = false;
                act = che;
            }else {
                System.out.println("输入的数只能为整数1或2,请重新输入！");
            }
        }
        switch (act) {
            case 1:
                ThreadLocalRandom random = ThreadLocalRandom.current();
                num = random.nextInt(1, 7);
                break;
            case 2:
                System.out.println("恭喜您激活作弊码，请输入骰子点数！");
                num = scanner.nextInt();
                break;
        }
        System.out.println("骰子点数是" + num);
        return num;
    }

/*参数：class（地图m）
* 返回值：int
* 功能：接收玩家输入的飞机号，判断输入是否合法（），返回当前玩家所选飞机在numPlane中的索引值
* */
     int selePlane(Maps m){
        int turn = (m.flag+1)%2;//判断几号玩家
            Scanner scanner = new Scanner(System.in);//第一次输入
            int a = scanner.nextInt();
            while(true){
                if(a<1||a>4){//判断输入是否正确，不对就再次输入直到对为止
                    System.out.println("输入飞机编号有误，请重新输入（1-4）：");
                    scanner = new Scanner(System.in);
                    a = scanner.nextInt();
                }else{
                    int num = turn*4+a-1;//飞机号码
                    return num;
                }
            }
        }

/*参数：int
* 返回值：boolean
* 功能：接收骰子点数，判断机场中的飞机是否能起飞。能则返回true，否则返回false*/
    boolean judgeLegal (int touZi){
        //如果骰子是5，6，则任何飞机可以移动
        //如果不是5，6则仅有非机场飞机可以移动，非机场飞机的数值为非0
        if(touZi==5||touZi==6){
            return true;
        } else {
            System.out.println("非法移动");
            return false;
        }
    }

/*参数：int，class（地图m）
* 返回值：void
* 功能：移动飞机*/
    void movePlane(int x, int y,Maps m){
        if(m.flag % 2 == 1){
            m.Map[m.Road1[m.numPlane[y] + x][0]] [m.Road1[m.numPlane[y] + x][1]] = m.Map[m.Road1[m.numPlane[y]][0]] [m.Road1[m.numPlane[y]][1]];
            m.Map[m.Road1[m.numPlane[y]][0]] [m.Road1[m.numPlane[y]][1]] = "🟦";
            m.numPlane[y] += x;
        }else {
            m.Map[m.Road2[m.numPlane[y] + x][0]] [m.Road2[m.numPlane[y] + x][1]] = m.Map[m.Road2[m.numPlane[y]][0]] [m.Road2[m.numPlane[y]][1]];
            m.Map[m.Road2[m.numPlane[y]][0]] [m.Road2[m.numPlane[y]][1]] = "🟦";
            m.numPlane[y] += x;
        }
    }

/*参数：int，class（地图m）
* 返回值：void
* 功能：将飞机起飞（从机场移动到棋牌的起点）*/
    void flyPlane(int y, Maps m){
        switch (y){
            case 0 :
                m.Map[3][3] = "⬛";
                m.Map[8][2] = "🚀";
                m.numPlane[0] = 0;
                break;
            case 1:
                m.Map[3][6] = "⬛";
                m.Map[8][2] = "🛫";
                m.numPlane[1] = 0;
                break;
            case 2:
                m.Map[6][3] = "⬛";
                m.Map[8][2] = "🛬";
                m.numPlane[2] = 0;
                break;
            case 3:
                m.Map[6][6] = "⬛";
                m.Map[8][2] = "🚁";
                m.numPlane[3] = 0;
                break;
            case 4:
                m.Map[16][16] = "⬛";
                m.Map[14][20] = "🚈";
                m.numPlane[4] = 0;
                break;
            case 5:
                m.Map[16][19] = "⬛";
                m.Map[14][20] = "🚄";
                m.numPlane[5] = 0;
                break;
            case 6:
                m.Map[19][16] = "⬛";
                m.Map[14][20] = "🚞";
                m.numPlane[6] = 0;
                break;
            case 7:
                m.Map[19][19] = "⬛";
                m.Map[14][20] = "🚃";
                m.numPlane[7] = 0;
                break;
        }
    }

/*参数：int，class（地图m，界面v）
* 返回值：boolean
* 功能：若有飞机到达终点，玩家对应的desti计数器加一；判断是否有玩家的全部飞机到达终点*/
    void isWin(int x,int y,Maps m,View v) {
        try {
            movePlane(x,y,m);
        }catch (Exception out){
            if (m.flag % 2 == 1){
                m.Map[m.Road1[m.numPlane[y]][0]] [m.Road1[m.numPlane[y]][1]] = "🟦";
            }else {
                m.Map[m.Road2[m.numPlane[y]][0]] [m.Road2[m.numPlane[y]][1]] = "🟦";
            }
            m.Map[11][11] = "🚩";
            System.err.println("恭喜到达终点！");
            if ((((m.flag + 1) % 2) + 1) == 1){
                m.desti1 +=1;
            }else {
                m.desti2 +=1;
            }
        }
        if (m.desti1 == 4){
            System.out.println("恭喜1号玩家胜利！");
            v.victionFace(m);
            System.exit(0);
        }
        if (m.desti2 == 4){
            System.out.println("恭喜2号玩家胜利！");
            v.victionFace(m);
            System.exit(0);
        }
    }


/*  参数：void
*   返回值：boolean
*   功能：检查当前玩家所有的飞机是不是全部都在机场上，是则返回true，不是返回false*/
    boolean judgFull(Maps m){
        if (m.flag%2 == 0){
            if (m.Map[3][3] == "🚀" && m.Map[3][6] == "🛫" && m.Map[6][3] == "🛬" && m.Map[6][6] == "🚁"){
                return true;
            }else {
                return false;
            }
        }else {
            if (m.Map[16][16] == "🚈" &&m.Map[16][19] == "🚄" && m.Map[19][16] == "🚞" && m.Map[19][19] == "🚃"){
                return true;
            }else {
                return false;
            }
        }
    }

/*  参数：void
    返回值：int
    功能：接收当前玩家所选择的飞机编号对应的索引，判断该飞机是在机场还是在棋盘上了。若该飞机在机场，返回1，否则返回2*/
    int checkWhere(int n,Maps m){
        int ret;
            switch (n){
                case 0:
                    if (m.Map[3][3] == "🚀"){
                        ret = 1;
                    }else {
                        ret = 2;
                    }
                    break;
                case 1:
                    if (m.Map[3][6] == "🛫"){
                        ret = 1;
                    }else {
                        ret = 2;
                    }
                    break;
                case 2:
                    if (m.Map[6][3] == "🛬"){
                        ret = 1;
                    }else {
                        ret = 2;
                    }
                    break;
                case 3:
                    if (m.Map[6][6] == "🚁"){
                        ret = 1;
                    }else {
                        ret = 2;
                    }
                    break;
                case 4:
                    if (m.Map[16][16] == "🚈"){
                        ret = 1;
                    }else {
                        ret = 2;
                    }
                    break;
                case 5:
                    if (m.Map[16][19] == "🚄"){
                        ret = 1;
                    }else {
                        ret = 2;
                    }
                    break;
                case 6:
                    if (m.Map[19][16] == "🚞"){
                        ret = 1;
                    }else {
                        ret = 2;
                    }
                    break;
                case 7:
                    if (m.Map[19][19] == "🚃"){
                        ret = 1;
                    }else {
                        ret = 2;
                    }
                    break;
                default:
                    ret = 2;
                    break;
        }
        return ret;
    }

}