// https://github.com/tjwldnjss13/Self-Organizing-Map.git

import java.util.ArrayList;
import java.util.Scanner;

public class SOM {
    public static double[][] PATTERN_1 = {{0,0,1,1,0,0,0,
                                           0,0,0,1,0,0,0,
                                           0,0,1,1,0,0,0,
                                           0,0,1,0,1,0,0,
                                           0,0,1,0,1,0,0,
                                           0,1,1,1,1,1,0,
                                           0,1,0,0,0,1,0,
                                           0,1,0,0,0,1,0,
                                           1,1,1,0,1,1,1},
                                          {1,1,1,1,1,1,0,
                                           0,1,0,0,0,0,1,
                                           0,1,0,0,0,0,1,
                                           0,1,0,0,0,0,1,
                                           0,1,1,1,1,1,0,
                                           0,1,0,0,0,0,1,
                                           0,1,0,0,0,0,1,
                                           0,1,0,0,0,0,1,
                                           1,1,1,1,1,1,0},
                                          {0,0,1,1,1,1,1,
                                           0,1,0,0,0,0,1,
                                           1,0,0,0,0,0,0,
                                           1,0,0,0,0,0,0,
                                           1,0,0,0,0,0,0,
                                           1,0,0,0,0,0,0,
                                           1,0,0,0,0,0,0,
                                           0,1,0,0,0,0,1,
                                           0,0,1,1,1,1,0},
                                          {1,1,1,1,1,0,0,
                                           0,1,0,0,0,1,0,
                                           0,1,0,0,0,0,1,
                                           0,1,0,0,0,0,1,
                                           0,1,0,0,0,0,1,
                                           0,1,0,0,0,0,1,
                                           0,1,0,0,0,0,1,
                                           0,1,0,0,0,1,0,
                                           1,1,1,1,1,0,0},
                                          {1,1,1,1,1,1,1,
                                           0,1,0,0,0,0,1,
                                           0,1,0,0,0,0,0,
                                           0,1,0,1,0,0,0,
                                           0,1,1,1,0,0,0,
                                           0,1,0,1,0,0,0,
                                           0,1,0,0,0,0,0,
                                           0,1,0,0,0,0,1,
                                           1,1,1,1,1,1,1},
                                          {0,0,0,1,1,1,1,
                                           0,0,0,0,0,1,0,
                                           0,0,0,0,0,1,0,
                                           0,0,0,0,0,1,0,
                                           0,0,0,0,0,1,0,
                                           0,0,0,0,0,1,0,
                                           0,1,0,0,0,1,0,
                                           0,1,0,0,0,1,0,
                                           0,0,1,1,1,0,0},
                                          {1,1,1,0,0,1,1,
                                           0,1,0,0,1,0,0,
                                           0,1,0,1,0,0,0,
                                           0,1,1,0,0,0,0,
                                           0,1,1,0,0,0,0,
                                           0,1,0,1,0,0,0,
                                           0,1,0,0,1,0,0,
                                           0,1,0,0,0,1,0,
                                           1,1,1,0,0,1,1}};
    public static double[][] PATTERN_2 = {{0,0,0,1,0,0,0,
                                           0,0,0,1,0,0,0,
                                           0,0,0,1,0,0,0,
                                           0,0,1,0,1,0,0,
                                           0,0,1,0,1,0,0,
                                           0,1,0,0,0,1,0,
                                           0,1,1,1,1,1,0,
                                           0,1,0,0,0,1,0,
                                           0,1,0,0,0,1,0},
                                          {1,1,1,1,1,1,0,
                                           1,0,0,0,0,0,1,
                                           1,0,0,0,0,0,1,
                                           1,0,0,0,0,0,1,
                                           1,1,1,1,1,1,0,
                                           1,0,0,0,0,0,1,
                                           1,0,0,0,0,0,1,
                                           1,0,0,0,0,0,1,
                                           1,1,1,1,1,1,0},
                                          {0,0,1,1,1,0,0,
                                           0,1,0,0,0,1,0,
                                           1,0,0,0,0,0,1,
                                           1,0,0,0,0,0,0,
                                           1,0,0,0,0,0,0,
                                           1,0,0,0,0,0,0,
                                           1,0,0,0,0,0,1,
                                           0,1,0,0,0,1,0,
                                           0,0,1,1,1,0,0},
                                          {1,1,1,1,1,0,0,
                                           1,0,0,0,0,1,0,
                                           1,0,0,0,0,0,1,
                                           1,0,0,0,0,0,1,
                                           1,0,0,0,0,0,1,
                                           1,0,0,0,0,0,1,
                                           1,0,0,0,0,0,1,
                                           1,0,0,0,0,1,0,
                                           1,1,1,1,1,0,0},
                                          {1,1,1,1,1,1,1,
                                           1,0,0,0,0,0,0,
                                           1,0,0,0,0,0,0,
                                           1,0,0,0,0,0,0,
                                           1,1,1,1,1,0,0,
                                           1,0,0,0,0,0,0,
                                           1,0,0,0,0,0,0,
                                           1,0,0,0,0,0,0,
                                           1,1,1,1,1,1,1},
                                          {0,0,0,0,0,1,0,
                                           0,0,0,0,0,1,0,
                                           0,0,0,0,0,1,0,
                                           0,0,0,0,0,1,0,
                                           0,0,0,0,0,1,0,
                                           0,0,0,0,0,1,0,
                                           0,1,0,0,0,1,0,
                                           0,1,0,0,0,1,0,
                                           0,0,1,1,1,0,0},
                                          {1,0,0,0,0,1,0,
                                           1,0,0,0,1,0,0,
                                           1,0,0,1,0,0,0,
                                           1,0,1,0,0,0,0,
                                           1,1,0,0,0,0,0,
                                           1,0,1,0,0,0,0,
                                           1,0,0,1,0,0,0,
                                           1,0,0,0,1,0,0,
                                           1,0,0,0,0,1,0}};
    public static double[][] PATTERN_3 = {{0,0,0,1,0,0,0,
                                           0,0,0,1,0,0,0,
                                           0,0,1,0,1,0,0,
                                           0,0,1,0,1,0,0,
                                           0,1,0,0,0,1,0,
                                           0,1,1,1,1,1,0,
                                           1,0,0,0,0,0,1,
                                           1,0,0,0,0,0,1,
                                           1,1,0,0,0,1,1},
                                          {1,1,1,1,1,1,0,
                                           0,1,0,0,0,0,1,
                                           0,1,0,0,0,0,1,
                                           0,1,1,1,1,1,0,
                                           0,1,0,0,0,0,1,
                                           0,1,0,0,0,0,1,
                                           0,1,0,0,0,0,1,
                                           0,1,0,0,0,0,1,
                                           1,1,1,1,1,1,0},
                                          {0,0,1,1,1,0,1,
                                           0,1,0,0,0,1,1,
                                           1,0,0,0,0,0,1,
                                           1,0,0,0,0,0,0,
                                           1,0,0,0,0,0,0,
                                           1,0,0,0,0,0,0,
                                           1,0,0,0,0,0,1,
                                           0,1,0,0,0,1,0,
                                           0,0,1,1,1,0,0},
                                          {1,1,1,1,1,0,0,
                                           0,1,0,0,0,1,0,
                                           0,1,0,0,0,0,1,
                                           0,1,0,0,0,0,1,
                                           0,1,0,0,0,0,1,
                                           0,1,0,0,0,0,1,
                                           0,1,0,0,0,0,1,
                                           0,1,0,0,0,1,0,
                                           1,1,1,1,1,0,0},
                                          {1,1,1,1,1,1,1,
                                           0,1,0,0,0,0,1,
                                           0,1,0,0,1,0,0,
                                           0,1,1,1,1,0,0,
                                           0,1,0,0,1,0,0,
                                           0,1,0,0,0,0,0,
                                           0,1,0,0,0,0,0,
                                           0,1,0,0,0,0,1,
                                           1,1,1,1,1,1,1},
                                          {0,0,0,0,1,1,1,
                                           0,0,0,0,0,1,0,
                                           0,0,0,0,0,1,0,
                                           0,0,0,0,0,1,0,
                                           0,0,0,0,0,1,0,
                                           0,0,0,0,0,1,0,
                                           0,0,0,0,0,1,0,
                                           0,1,0,0,0,1,0,
                                           0,0,1,1,1,0,0},
                                          {1,1,1,0,0,1,1,
                                           0,1,0,0,0,1,0,
                                           0,1,0,0,1,0,0,
                                           0,1,0,1,0,0,0,
                                           0,1,1,0,0,0,0,
                                           0,1,0,1,0,0,0,
                                           0,1,0,0,1,0,0,
                                           0,1,0,0,0,1,0,
                                           1,1,1,0,0,1,1}};

    public int maxIteration = 0;
    public double learningRate = 0.6;
    public double[][] weight = new double[25][63];
    public double[] distance = new double[25];

    public static void main(String[] args) {
        SOM som = new SOM();
        int iteration = 0;

        som.readMaxIteration();

        System.out.println("---------------Start Learning-------------");
        System.out.println("[Iteration : " + som.maxIteration + "]");
        System.out.println();
        System.out.println("<1st Experiment>");
        while (iteration < som.maxIteration) {
            //System.out.println((iteration+1) + " iteration start");
            som.initWeight();
            som.changeWeight(1);
            som.decreaseLearningRate();

            //System.out.println((iteration+1) + " iteration done");
            iteration++;
        }
        som.printResult();

        iteration = 0;
        System.out.println();
        System.out.println("<2nd Experiment>");
        while (iteration < som.maxIteration) {
            //System.out.println((iteration+1) + " iteration start");
            som.initWeight();
            som.changeWeight(2);
            som.decreaseLearningRate();

            //System.out.println((iteration+1) + " iteration done");
            iteration++;
        }
        som.printResult();

        iteration = 0;
        System.out.println();
        System.out.println("<3rd Experiment> (2nd에서 양옆의 node 2개씩 변경하도록 추가)");
        while (iteration < som.maxIteration) {
            //System.out.println((iteration+1) + " iteration start");
            som.initWeight();
            som.changeWeight(3);
            som.decreaseLearningRate();

            //System.out.println((iteration+1) + " iteration done");
            iteration++;
        }
        som.printResult();

        iteration = 0;
        System.out.println();
        System.out.println("<4th Experiment>");
        while (iteration < som.maxIteration) {
            //System.out.println((iteration+1) + " iteration start");
            som.initWeight();
            som.changeWeight(4);
            som.decreaseLearningRate();

            //System.out.println((iteration+1) + " iteration done");
            iteration++;
        }
        som.printResult();
    }

    void initWeight() {
        for (int i=0; i<25; i++) {
            for (int j=0; j<63; j++)
                this.weight[i][j] = Math.random();
        }
    }

    void initDistance() {
        for (int i=0; i<25; i++)
            this.distance[i] = 0;
    }

    void printWeight() {
        //System.out.println("-----------------Print Weight----------------");
        for (int i=0; i<25; i++) {
            System.out.print(i + ": <");
            for (int j=0; j<63; j++)
                System.out.print(Double.parseDouble(String.format("%.1f", this.weight[i][j])) + " ");
            System.out.println(">");
        }
    }

    void changeWeight(int iCase) {
        //System.out.println("-----------------Update Weight----------------");
        int winnerIndex = 0;
        int iPattern = 0;

        //System.out.print("1: Winner < ");
        for (int k=0; k<7; k++) {
            this.calcDistance(PATTERN_1[k], iPattern);
             winnerIndex = this.findWinnerNode();
            //System.out.print(winnerIndex + " ");
            this.calcWinnerWeight(PATTERN_1[k], winnerIndex, iCase);
            iPattern++;
        }
        //System.out.println(">");

        //System.out.print("2: Winner < ");
        for (int k=0; k<7; k++) {
            this.calcDistance(PATTERN_2[k], iPattern);
            winnerIndex = this.findWinnerNode();
            //System.out.print(winnerIndex + " ");
            this.calcWinnerWeight(PATTERN_2[k], winnerIndex, iCase);
            iPattern++;
        }
        //System.out.println(">");

        //System.out.print("3: Winner < ");
        for (int k=0; k<7; k++) {
            this.calcDistance(PATTERN_3[k], iPattern);
            winnerIndex = this.findWinnerNode();
            //System.out.print(winnerIndex + " ");
            this.calcWinnerWeight(PATTERN_3[k], winnerIndex, iCase);
            iPattern++;
        }
        //System.out.println(">");
    }

    void calcWinnerWeight(double[] pattern, int winnerIndex, int iCase) {
        //System.out.println("-----------------Update winner node----------------");
        switch(iCase) {
            case 1: {
                for (int i=0; i<63; i++) 
                    this.weight[winnerIndex][i] = (1 - this.learningRate) * this.weight[winnerIndex][i] + this.learningRate * pattern[i];
                break;
            }
            case 2: {
                for (int i=0; i<63; i++) {
                    this.weight[winnerIndex][i] = (1 - this.learningRate) * this.weight[winnerIndex][i] + this.learningRate * pattern[i];

                    switch (winnerIndex) {
                        case 0: {
                            this.weight[winnerIndex+1][i] = (1 - this.learningRate) * this.weight[winnerIndex+1][i] + this.learningRate * pattern[i];
                            break;
                        }
                        case 24: {
                            this.weight[winnerIndex-1][i] = (1 - this.learningRate) * this.weight[winnerIndex-1][i] + this.learningRate * pattern[i];
                            break;
                        }
                        default: {
                            this.weight[winnerIndex-1][i] = (1 - this.learningRate) * this.weight[winnerIndex-1][i] + this.learningRate * pattern[i];
                            this.weight[winnerIndex+1][i] = (1 - this.learningRate) * this.weight[winnerIndex+1][i] + this.learningRate * pattern[i];
                            break;
                        }
                    }
                }
                break;
            }
            case 3: {
                for (int i=0; i<63; i++) {
                    this.weight[winnerIndex][i] = (1 - this.learningRate) * this.weight[winnerIndex][i] + this.learningRate * pattern[i];

                    switch (winnerIndex) {
                        case 0: {
                            this.weight[winnerIndex+1][i] = (1 - this.learningRate) * this.weight[winnerIndex+1][i] + this.learningRate * pattern[i];
                            this.weight[winnerIndex+2][i] = (1 - this.learningRate) * this.weight[winnerIndex+2][i] + this.learningRate * pattern[i];
                            break;
                        }
                        case 1: {
                            this.weight[winnerIndex-1][i] = (1 - this.learningRate) * this.weight[winnerIndex-1][i] + this.learningRate * pattern[i];
                            this.weight[winnerIndex+1][i] = (1 - this.learningRate) * this.weight[winnerIndex+1][i] + this.learningRate * pattern[i];
                            this.weight[winnerIndex+2][i] = (1 - this.learningRate) * this.weight[winnerIndex+2][i] + this.learningRate * pattern[i];
                            break;
                        }
                        case 23: {
                            this.weight[winnerIndex-2][i] = (1 - this.learningRate) * this.weight[winnerIndex-2][i] + this.learningRate * pattern[i];
                            this.weight[winnerIndex-1][i] = (1 - this.learningRate) * this.weight[winnerIndex-1][i] + this.learningRate * pattern[i];
                            this.weight[winnerIndex+1][i] = (1 - this.learningRate) * this.weight[winnerIndex+1][i] + this.learningRate * pattern[i];
                            break;
                        }
                        case 24: {
                            this.weight[winnerIndex-2][i] = (1 - this.learningRate) * this.weight[winnerIndex-2][i] + this.learningRate * pattern[i];
                            this.weight[winnerIndex-1][i] = (1 - this.learningRate) * this.weight[winnerIndex-1][i] + this.learningRate * pattern[i];
                            break;
                        }
                        default: {
                            this.weight[winnerIndex-2][i] = (1 - this.learningRate) * this.weight[winnerIndex-2][i] + this.learningRate * pattern[i];
                            this.weight[winnerIndex-1][i] = (1 - this.learningRate) * this.weight[winnerIndex-1][i] + this.learningRate * pattern[i];
                            this.weight[winnerIndex+1][i] = (1 - this.learningRate) * this.weight[winnerIndex+1][i] + this.learningRate * pattern[i];
                            this.weight[winnerIndex+2][i] = (1 - this.learningRate) * this.weight[winnerIndex+2][i] + this.learningRate * pattern[i];
                            break;
                        }
                    }
                }
                break;
            }
            case 4: {
                for (int i=0; i<63; i++) {
                    this.weight[winnerIndex][i] = (1 - this.learningRate) * this.weight[winnerIndex][i] + this.learningRate * pattern[i];
                    
                    switch (winnerIndex) {
                        case 0: {
                            this.weight[winnerIndex+1][i] = (1 - this.learningRate) * this.weight[winnerIndex][i] + this.learningRate * pattern[i];
                            this.weight[winnerIndex+5][i] = (1 - this.learningRate) * this.weight[winnerIndex+5][i] + this.learningRate * pattern[i];
                            break;
                        }
                        case 4: {
                            this.weight[winnerIndex-1][i] = (1 - this.learningRate) * this.weight[winnerIndex-1][i] + this.learningRate * pattern[i];
                            this.weight[winnerIndex+5][i] = (1 - this.learningRate) * this.weight[winnerIndex+5][i] + this.learningRate * pattern[i];
                            break;
                        }
                        case 20: {
                            this.weight[winnerIndex-5][i] = (1 - this.learningRate) * this.weight[winnerIndex-5][i] + this.learningRate * pattern[i];
                            this.weight[winnerIndex+1][i] = (1 - this.learningRate) * this.weight[winnerIndex+1][i] + this.learningRate * pattern[i];
                            break;
                        }
                        case 24: {
                            this.weight[winnerIndex-5][i] = (1 - this.learningRate) * this.weight[winnerIndex-5][i] + this.learningRate * pattern[i];
                            this.weight[winnerIndex-1][i] = (1 - this.learningRate) * this.weight[winnerIndex-1][i] + this.learningRate * pattern[i];
                            break;
                        }
                        case 1:
                        case 2:
                        case 3: {
                            this.weight[winnerIndex-1][i] = (1 - this.learningRate) * this.weight[winnerIndex-1][i] + this.learningRate * pattern[i];
                            this.weight[winnerIndex+1][i] = (1 - this.learningRate) * this.weight[winnerIndex+1][i] + this.learningRate * pattern[i];
                            this.weight[winnerIndex+5][i] = (1 - this.learningRate) * this.weight[winnerIndex+5][i] + this.learningRate * pattern[i];
                            break;
                        }
                        case 5:
                        case 10:
                        case 15: {
                            this.weight[winnerIndex-5][i] = (1 - this.learningRate) * this.weight[winnerIndex-5][i] + this.learningRate * pattern[i];
                            this.weight[winnerIndex+1][i] = (1 - this.learningRate) * this.weight[winnerIndex+1][i] + this.learningRate * pattern[i];
                            this.weight[winnerIndex+5][i] = (1 - this.learningRate) * this.weight[winnerIndex+5][i] + this.learningRate * pattern[i];
                            break;
                        }
                        case 9:
                        case 14:
                        case 19: {
                            this.weight[winnerIndex-5][i] = (1 - this.learningRate) * this.weight[winnerIndex-5][i] + this.learningRate * pattern[i];
                            this.weight[winnerIndex-1][i] = (1 - this.learningRate) * this.weight[winnerIndex-1][i] + this.learningRate * pattern[i];
                            this.weight[winnerIndex+5][i] = (1 - this.learningRate) * this.weight[winnerIndex+5][i] + this.learningRate * pattern[i];
                            break;
                        }
                        case 21:
                        case 22:
                        case 23: {
                            this.weight[winnerIndex-5][i] = (1 - this.learningRate) * this.weight[winnerIndex-5][i] + this.learningRate * pattern[i];
                            this.weight[winnerIndex-1][i] = (1 - this.learningRate) * this.weight[winnerIndex-1][i] + this.learningRate * pattern[i];
                            this.weight[winnerIndex+1][i] = (1 - this.learningRate) * this.weight[winnerIndex+1][i] + this.learningRate * pattern[i];
                            break;
                        }
                        default: {
                            this.weight[winnerIndex-5][i] = (1 - this.learningRate) * this.weight[winnerIndex-5][i] + this.learningRate * pattern[i];
                            this.weight[winnerIndex-1][i] = (1 - this.learningRate) * this.weight[winnerIndex-1][i] + this.learningRate * pattern[i];
                            this.weight[winnerIndex+1][i] = (1 - this.learningRate) * this.weight[winnerIndex+1][i] + this.learningRate * pattern[i];
                            this.weight[winnerIndex+5][i] = (1 - this.learningRate) * this.weight[winnerIndex+5][i] + this.learningRate * pattern[i];
                            break;
                        }
                    }
                }
                break;
            }
        }
    }

// 0 / 1 / 2 / 3 / 4
// 5 / 6 / 7 / 8 / 9 
// 10/ 11/ 12/ 13/ 14
// 15/ 16/ 17/ 18/ 19
// 20/ 21/ 22/ 23/ 24

    void calcDistance(double[] pattern, int iPattern) {
        //System.out.println("-----------------Calculate distance----------------");
        this.initDistance();
        //System.out.print("D" + iPattern + ": <");
        for (int i=0; i<25; i++) {
            for (int j=0; j<63; j++) {
                this.distance[i] += this.euclidean(this.weight[i][j], pattern[j]);
            }
            //System.out.print(Double.parseDouble(String.format("%.1f", this.distance[i])) + " ");
        }
        //System.out.println(">");
    }

    void calcDistance(double[] pattern) {
        this.initDistance();
        for (int i=0; i<25; i++) {
            for (int j=0; j<63; j++) {
                this.distance[i] += this.euclidean(this.weight[i][j], pattern[j]);
            }
        }
    }

    int findWinnerNode() {
        int winner = 0; 
        double lowestDistance = 10000;

        for (int i=0; i<25; i++) {
            if (this.distance[i] < lowestDistance) {
                lowestDistance = this.distance[i];
                winner = i;
            }
        }

        return winner;
    }

    void printResult() {
        //System.out.println("-----------------Print result----------------");
        ArrayList<Integer>[] categorized = new ArrayList[25];
        int winnerIndex = 0;
        int iPattern = 0;
        boolean nullFlag = true;

        for (int i=0; i<categorized.length; i++)
            categorized[i] = new ArrayList<Integer>();

        for (int k=0; k<7; k++) {
            this.calcDistance(PATTERN_1[k]);
            winnerIndex = this.findWinnerNode();
            categorized[winnerIndex].add(iPattern);
            iPattern++;
        }
        for (int k=0; k<7; k++) {
            this.calcDistance(PATTERN_2[k]);
            winnerIndex = this.findWinnerNode();
            categorized[winnerIndex].add(iPattern);
            iPattern++;
        }
        for (int k=0; k<7; k++) {
            this.calcDistance(PATTERN_3[k]);
            winnerIndex = this.findWinnerNode();
            categorized[winnerIndex].add(iPattern);
            iPattern++;
        }

        for (int i=0; i<25; i++) {
            nullFlag = true;
            if (categorized[i].size() != 0) {
                nullFlag = false;
                System.out.print((i+1) + " Node : ");
                for (int j=0; j<categorized[i].size(); j++) {
                    System.out.print(this.categorize(categorized[i].get(j)));
                    if (j != categorized[i].size() - 1)
                        System.out.print(", ");
                }
            }
            if (!nullFlag)
                System.out.println();
        }
    }

    String categorize(int iPattern) {
        String patternStr = null;

        switch(iPattern) {
            case 0: {
                patternStr = "A1";
                break;
            }
            case 1: {
                patternStr = "B1";
                break;
            }
            case 2: {
                patternStr = "C1";
                break;
            }
            case 3: {
                patternStr = "D1";
                break;
            }
            case 4: {
                patternStr = "E1";
                break;
            }
            case 5: {
                patternStr = "J1";
                break;
            }
            case 6: {
                patternStr = "K1";
                break;
            }
            case 7: {
                patternStr = "A2";
                break;
            }
            case 8: {
                patternStr = "B2";
                break;
            }
            case 9: {
                patternStr = "C2";
                break;
            }
            case 10: {
                patternStr = "D2";
                break;
            }
            case 11: {
                patternStr = "E2";
                break;
            }
            case 12: {
                patternStr = "J2";
                break;
            }
            case 13: {
                patternStr = "K2";
                break;
            }
            case 14: {
                patternStr = "A3";
                break;
            }
            case 15: {
                patternStr = "B3";
                break;
            }
            case 16: {
                patternStr = "C3";
                break;
            }
            case 17: {
                patternStr = "D3";
                break;
            }
            case 18: {
                patternStr = "E3";
                break;
            }
            case 19: {
                patternStr = "J3";
                break;
            }
            case 20: {
                patternStr = "K3";
                break;
            }
        }

        return patternStr;
    }

    void decreaseLearningRate() {
        //System.out.println("-----------------Decrease learning rate----------------");
        this.learningRate = this.learningRate * 0.5;
    }

    void readMaxIteration() {
        Scanner scan = new Scanner(System.in);
        System.out.print("학습 반복 횟수를 입력하세요 (150 이상 권장) : ");
        this.maxIteration = scan.nextInt();
        System.out.println();

        scan.close();
    }

    double euclidean(double x, double y) {
        return (x - y) * (x - y);
    }
}