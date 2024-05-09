package com.ripper.budding.design.strategy.nofielse;

/**
 * 多态机制
 *
 * @author shandowF
 * @date 2018年1月10日
 */
public class NoIfElse_Polymorphism {

    public static void main(String[] args) {
//		MyPaper myPaper = new MyPaper();

    }

    class White {
        public void getPenColor() {
            System.out.println("You need a white pen!");
        }
    }

    class Red {
        public void getPenColor() {
            System.out.println("You need a red pen!");
        }
    }

    class Blue {
        public void getPenColor() {
            System.out.println("You need a blue pen!");
        }
    }

    class Black {
        public void getPenColor() {
            System.out.println("You need a black pen!");
        }
    }

    class MyPaper {


//		public void choice(White white) {
//			white.getPenColor();
//		}
//
//		public void choice(Red red) {
//			red.getPenColor();
//		}
//
//		public void choice(Blue blue) {
//			blue.getPenColor();
//		}
//
//		public void choice(Black black) {
//			black.getPenColor();
//		}
    }
}