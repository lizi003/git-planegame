public class View {
/*参数：void
* 返回值：void
* 功能：打印初始界面
* */
    void initFace(){
            System.out.println("_________________________游戏菜单_________________________");
            System.out.println("|\t\t\t\t\t\t1、开始游戏\t\t\t\t\t\t|");
            System.out.println("|\t\t\t\t\t\t2、玩法介绍\t\t\t\t\t\t|");
            System.out.println("|\t\t\t\t\t\t3、排行榜\t\t\t\t\t\t|");
            System.out.println("|\t\t\t\t\t\t4、退出游戏\t\t\t\t\t\t|");
            System.out.println("_________________________________________________________");
        System.out.println();
        System.out.println();
}

/*参数：void
* 返回值：void
* 功能：打印玩法介绍界面
* */
    void introductionFace(){
        System.out.println("_________________________玩法介绍_________________________");
        System.out.println("");
        System.out.println("本款“飞行棋”小游戏允许两位玩家进行游戏，玩家只需要根据提示进行对应的按键输入操作即可。");
        System.out.println("游戏基本规则：玩家按顺序轮流投掷骰子，之后选择适合的飞机，沿着棋盘，移动投掷出的骰子点数，");
        System.out.println("游戏一开始，两位玩家的飞机都处于飞机场上，若玩家想将飞机场中的飞机“起飞”至棋盘的起点，则需要将骰子掷出5或6点方可。");
        System.out.println("温馨提示：当一架飞机移动到一个有飞机的格子上时，两架飞机会相撞坠机哦(⊙o⊙)，若到最后没有4架飞机到终点是不hi胜利的哦！");
        System.out.println("_________________________________________________________");
        System.out.println("");
    }

/*参数：void
* 返回值：void
* 功能：打印排行榜界面
* */
    void rankingFace() {
        System.out.println("_________________________排行榜单_________________________");
        System.out.println("*********************************************************");
        System.out.println("*********************************************************");
        System.out.println("*********************************************************");
        System.out.println();
        System.out.println();
        System.out.println("|\t\t\t\t\t\t*敬请期待*\t\t\t\t\t\t|");
        System.out.println();
        System.out.println();
        System.out.println("*********************************************************");
        System.out.println("*********************************************************");
        System.out.println("*********************************************************");
        System.out.println("_________________________________________________________");
        System.out.println();
        System.out.println();
    }

/*参数：class（地图m）
* 返回值：void
* 功能：打印游戏胜利界面
* */
    void victionFace(Maps m){
        System.out.println("_________________________游戏结束_________________________");
        System.out.println();
        System.out.println();
        System.out.println("|" + "\t\t\t\t\t  " + "恭喜" + (((m.flag + 1) % 2) + 1) + "号玩家胜利!" + "  \t\t\t\t\t" + "|");
        System.out.println();
        System.out.println();
        System.out.println("_________________________________________________________");
        System.out.println();
        System.out.println();
    }

/*参数：class（地图m）
* 返回值：void
* 功能：打印游戏棋盘
* */
    void initGameFace(Maps m) {
        System.out.println("_______________________游戏界面_______________________");
        for (int i = 0; i < m.Map.length; i++) {
            for (int j = 0; j < m.Map[i].length; j++) {
                System.out.print(m.Map[i][j]);
            }
            System.out.println(" ");
        }
    }
}
