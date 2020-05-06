package sample;


import java.net.URL;
import java.util.*;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button button_1;

    @FXML
    private Button button_5;

    @FXML
    private Button button_9;

    @FXML
    private Button button_13;

    @FXML
    private Button button_17;

    @FXML
    private Button button_21;

    @FXML
    private Button button_25;

    @FXML
    private Button button_29;

    @FXML
    private Button button_33;

    @FXML
    private Button button_2;

    @FXML
    private Button button_6;

    @FXML
    private Button button_10;

    @FXML
    private Button button_14;

    @FXML
    private Button button_18;

    @FXML
    private Button button_22;

    @FXML
    private Button button_26;

    @FXML
    private Button button_30;

    @FXML
    private Button button_3;

    @FXML
    private Button button_7;

    @FXML
    private Button button_11;

    @FXML
    private Button button_15;

    @FXML
    private Button button_19;

    @FXML
    private Button button_23;

    @FXML
    private Button button_27;

    @FXML
    private Button button_31;

    @FXML
    private Button button_4;

    @FXML
    private Button button_8;

    @FXML
    private Button button_12;

    @FXML
    private Button button_16;

    @FXML
    private Button button_20;

    @FXML
    private Button button_24;

    @FXML
    private Button button_28;

    @FXML
    private Button button_32;

    @FXML
    private Button button_34;

    @FXML
    private Button button_35;

    @FXML
    private Button button_36;

    @FXML
    private Button button_37;

    @FXML
    private Button button_38;

    @FXML
    private Button button_39;

    @FXML
    private Button button_40;

    @FXML
    private Button button_41;

    @FXML
    private Button button_42;

    @FXML
    private Button button_43;

    @FXML
    private Button button_44;

    @FXML
    private Button button_45;

    @FXML
    private Button button_46;

    @FXML
    private Button button_47;

    @FXML
    private Button button_48;

    @FXML
    private Button button_49;

    @FXML
    private TextField text_user;

    @FXML
    private TextField status;

    @FXML
    private Button clear;

    @FXML
    private Button game;

    @FXML
    private TextField rand_num;

    @FXML
    private TextArea win_status;

    @FXML
    private TextField balance;

    @FXML
    private TextField stav;

    @FXML
    private Button auto;

    final ArrayList number = new ArrayList();
    int num = 0;
    int win = 0;
    float money = 100;
    float stavka = 0;

    @FXML
    void initialize() {
        auto.setOnAction(event -> {
            number.clear();
            num = 0;
            Random random = new Random();

            final Set<Integer> numberSet1 = new HashSet<>();
            while (!(numberSet1.size() == 6))
                numberSet1.add(random.nextInt(49) + 1);
            final List<Integer> sortednum1 = new ArrayList<Integer>(numberSet1);
            Collections.sort(sortednum1);
            for(int i = 0; !(number.size() == 6); i++)
                number.add(sortednum1.get(i));
            text_user.setText(String.valueOf(number));
            num = 6;

        });
        status.setText("Выберите ставку, и 6 чисел и начинайте игру!!!");
        balance.setText(String.valueOf(money));
        clear.setOnAction(event -> {
            number.clear();
            num = 0;
            text_user.setText("");
            status.setText("");
        });
        game.setOnAction(event -> {

            if((Float.parseFloat((stav.getText()))<5))
                status.setText("Ставка должна быть больше 5!");

            if(Float.parseFloat((stav.getText()))>=money) {
                status.setText("Ставка не может быть больше ваших денег!");
            }else {
                stavka = Float.parseFloat((stav.getText()));
                if (num < 6) {
                    status.setText("Не верное количество выбраных вами цыфр, выберите 6!");
                } else {
                    Random random = new Random();
                    final Set<Integer> numberSet = new HashSet<>();
                    while (!(numberSet.size() == 6))
                        numberSet.add(random.nextInt(49) + 1);
                    final List<Integer> sortednum = new ArrayList<Integer>(numberSet);
                    Collections.sort(sortednum);
                    int i = 0, j = 0, num1, num2;
                    while (!(i == 6)) {
                        if(number.get(i) == sortednum.get(j)) ;
                        num1 = (int) number.get(i);
                        num2 = sortednum.get(j);
                        if (num1 == num2)
                            win += 1;
                        j++;
                        if (j == 6) {
                            j = 0;
                            i++;
                        }
                    }
                    final List<Integer> sortednum2 = new ArrayList<Integer>(number);
                    Collections.sort(sortednum2);

                    if (win == 0) {
                        win_status.setText("К сожалению вы ничего не угадали... Сумма выиграша: -" + stavka + "\n" + "Вы выбрали: " + sortednum2);
                        money -= stavka;
                    }
                    if (win == 1) {
                        win_status.setText("Вы угадали только 1 цыфру а нужно 3... Сумма выиграша: -" + (stavka) + "\n" + "Вы выбрали: " + sortednum2);
                        money -= stavka;
                    }
                    if (win == 2) {
                        win_status.setText("Поздравляю. Вы угадали " + String.valueOf(win) + " цыфры. Сумма выиграша: -" + (stavka) + "\n" + "Вы выбрали: " + sortednum2);
                        money -= stavka;
                    }
                    if (win == 3) {
                        win_status.setText("Поздравляю. Вы угадали " + String.valueOf(win) + " цыфры. Сумма выиграша: +" + (stavka * 3) + "\n" + "Вы выбрали: " + sortednum2);
                        money += stavka * 3;
                    }
                    if (win == 4) {
                        win_status.setText("Поздравляю. Вы угадали аж" + String.valueOf(win) + " цыфры. Сумма выиграша: +" + (stavka * 4) + "\n" + "Вы выбрали: " + sortednum2);
                        money += stavka * 4;
                    }
                    if (win == 5) {
                        win_status.setText("Поздравляю. Вы везунчик, вы угадали " + String.valueOf(win) + " цыфры. Сумма выиграша: +" + (stavka * 25) + "\n" + "Вы выбрали: " + sortednum2);
                        money += stavka * 50;
                    }
                    if (win == 6) {
                        win_status.setText("JAAAAAAAAAAAAACKPOOTTTTTT вы угадали все цыфры, и стали победителём игры!!!" + "\n" + "Вы выбрали: " + sortednum2);
                        money += stavka * 100;
                    }

                    rand_num.setText(String.valueOf(sortednum));
                    balance.setText(String.valueOf(money));
                    text_user.setText("");
                    win = 0;
                    number.clear();
                    status.clear();
                    num = 0;
                }
            }
        });

        //отвечает за нажатия цыфр!
        button_1.setOnAction(event -> {
            if(num >= 0 && num <= 5) {
                if ((number.indexOf(1)) == -1) {
                    number.add(1);
                    text_user.setText(String.valueOf(number));
                    num += 1;
                } else
                    status.setText("Число уже есть!");
            }else
                status.setText("Вы выбрали уже 6 чисел.");
        });
        button_2.setOnAction(event -> {
            if(num >= 0 && num <= 5) {
                if ((number.indexOf(2)) == -1) {
                    number.add(2);
                    text_user.setText(String.valueOf(number));
                    num += 1;
                } else
                    status.setText("Число уже есть!");
            }else
                status.setText("Вы выбрали уже 6 чисел.");
        });
        button_3.setOnAction(event -> {
            if(num >= 0 && num <= 5) {
                if ((number.indexOf(3)) == -1) {
                    number.add(3);
                    text_user.setText(String.valueOf(number));
                    num += 1;
                } else
                    status.setText("Число уже есть!");
            }else
                status.setText("Вы выбрали уже 6 чисел.");
        });
        button_4.setOnAction(event -> {
            if(num >= 0 && num <= 5) {
                if ((number.indexOf(4)) == -1) {
                    number.add(4);
                    text_user.setText(String.valueOf(number));
                    num += 1;
                } else
                    status.setText("Число уже есть!");
            }else
                status.setText("Вы выбрали уже 6 чисел.");
        });
        button_5.setOnAction(event -> {
            if(num >= 0 && num <= 5) {
                if ((number.indexOf(5)) == -1) {
                    number.add(5);
                    text_user.setText(String.valueOf(number));
                    num += 1;
                } else
                    status.setText("Число уже есть!");
            }else
                status.setText("Вы выбрали уже 6 чисел.");
        });
        button_6.setOnAction(event -> {
            if(num >= 0 && num <= 5) {
                if ((number.indexOf(6)) == -1) {
                    number.add(6);
                    text_user.setText(String.valueOf(number));
                    num += 1;
                } else
                    status.setText("Число уже есть!");
            }else
                status.setText("Вы выбрали уже 6 чисел.");
        });
        button_7.setOnAction(event -> {
            if(num >= 0 && num <= 5) {
                if ((number.indexOf(7)) == -1) {
                    number.add(7);
                    text_user.setText(String.valueOf(number));
                    num += 1;
                } else
                    status.setText("Число уже есть!");
            }else
                status.setText("Вы выбрали уже 6 чисел.");
        });
        button_8.setOnAction(event -> {
            if(num >= 0 && num <= 5) {
                if ((number.indexOf(8)) == -1) {
                    number.add(8);
                    text_user.setText(String.valueOf(number));
                    num += 1;
                } else
                    status.setText("Число уже есть!");
            }else
                status.setText("Вы выбрали уже 6 чисел.");
        });
        button_9.setOnAction(event -> {
            if(num >= 0 && num <= 5) {
                if ((number.indexOf(9)) == -1) {
                    number.add(9);
                    text_user.setText(String.valueOf(number));
                    num += 1;
                } else
                    status.setText("Число уже есть!");
            }else
                status.setText("Вы выбрали уже 6 чисел.");
        });
        button_10.setOnAction(event -> {
            if(num >= 0 && num <= 5) {
                if ((number.indexOf(10)) == -1) {
                    number.add(10);
                    text_user.setText(String.valueOf(number));
                    num += 1;
                } else
                    status.setText("Число уже есть!");
            }else
                status.setText("Вы выбрали уже 6 чисел.");
        });
        button_11.setOnAction(event -> {
            if(num >= 0 && num <= 5) {
                if ((number.indexOf(11)) == -1) {
                    number.add(11);
                    text_user.setText(String.valueOf(number));
                    num += 1;
                } else
                    status.setText("Число уже есть!");
            }else
                status.setText("Вы выбрали уже 6 чисел.");
        });
        button_12.setOnAction(event -> {
            if(num >= 0 && num <= 5) {
                if ((number.indexOf(12)) == -1) {
                    number.add(12);
                    text_user.setText(String.valueOf(number));
                    num += 1;
                } else
                    status.setText("Число уже есть!");
            }else
                status.setText("Вы выбрали уже 6 чисел.");
        });
        button_12.setOnAction(event -> {
            if(num >= 0 && num <= 5) {
                if ((number.indexOf(12)) == -1) {
                    number.add(12);
                    text_user.setText(String.valueOf(number));
                    num += 1;
                } else
                    status.setText("Число уже есть!");
            }else
                status.setText("Вы выбрали уже 6 чисел.");
        });
        button_13.setOnAction(event -> {
            if(num >= 0 && num <= 5) {
                if ((number.indexOf(13)) == -1) {
                    number.add(13);
                    text_user.setText(String.valueOf(number));
                    num += 1;
                } else
                    status.setText("Число уже есть!");
            }else
                status.setText("Вы выбрали уже 6 чисел.");
        });
        button_14.setOnAction(event -> {
            if(num >= 0 && num <= 5) {
                if ((number.indexOf(14)) == -1) {
                    number.add(14);
                    text_user.setText(String.valueOf(number));
                    num += 1;
                } else
                    status.setText("Число уже есть!");
            }else
                status.setText("Вы выбрали уже 6 чисел.");
        });
        button_15.setOnAction(event -> {
            if(num >= 0 && num <= 5) {
                if ((number.indexOf(15)) == -1) {
                    number.add(15);
                    text_user.setText(String.valueOf(number));
                    num += 1;
                } else
                    status.setText("Число уже есть!");
            }else
                status.setText("Вы выбрали уже 6 чисел.");
        });
        button_16.setOnAction(event -> {
            if(num >= 0 && num <= 5) {
                if ((number.indexOf(16)) == -1) {
                    number.add(16);
                    text_user.setText(String.valueOf(number));
                    num += 1;
                } else
                    status.setText("Число уже есть!");
            }else
                status.setText("Вы выбрали уже 6 чисел.");
        });
        button_17.setOnAction(event -> {
            if(num >= 0 && num <= 5) {
                if ((number.indexOf(17)) == -1) {
                    number.add(17);
                    text_user.setText(String.valueOf(number));
                    num += 1;
                } else
                    status.setText("Число уже есть!");
            }else
                status.setText("Вы выбрали уже 6 чисел.");
        });
        button_18.setOnAction(event -> {
            if(num >= 0 && num <= 5) {
                if ((number.indexOf(18)) == -1) {
                    number.add(18);
                    text_user.setText(String.valueOf(number));
                    num += 1;
                } else
                    status.setText("Число уже есть!");
            }else
                status.setText("Вы выбрали уже 6 чисел.");
        });
        button_19.setOnAction(event -> {
            if(num >= 0 && num <= 5) {
                if ((number.indexOf(19)) == -1) {
                    number.add(19);
                    text_user.setText(String.valueOf(number));
                    num += 1;
                } else
                    status.setText("Число уже есть!");
            }else
                status.setText("Вы выбрали уже 6 чисел.");
        });
        button_20.setOnAction(event -> {
            if(num >= 0 && num <= 5) {
                if ((number.indexOf(20)) == -1) {
                    number.add(20);
                    text_user.setText(String.valueOf(number));
                    num += 1;
                } else
                    status.setText("Число уже есть!");
            }else
                status.setText("Вы выбрали уже 6 чисел.");
        });
        button_21.setOnAction(event -> {
            if(num >= 0 && num <= 5) {
                if ((number.indexOf(21)) == -1) {
                    number.add(21);
                    text_user.setText(String.valueOf(number));
                    num += 1;
                } else
                    status.setText("Число уже есть!");
            }else
                status.setText("Вы выбрали уже 6 чисел.");
        });
        button_22.setOnAction(event -> {
            if(num >= 0 && num <= 5) {
                if ((number.indexOf(22)) == -1) {
                    number.add(22);
                    text_user.setText(String.valueOf(number));
                    num += 1;
                } else
                    status.setText("Число уже есть!");
            }else
                status.setText("Вы выбрали уже 6 чисел.");
        });
        button_23.setOnAction(event -> {
            if(num >= 0 && num <= 5) {
                if ((number.indexOf(23)) == -1) {
                    number.add(23);
                    text_user.setText(String.valueOf(number));
                    num += 1;
                } else
                    status.setText("Число уже есть!");
            }else
                status.setText("Вы выбрали уже 6 чисел.");
        });
        button_24.setOnAction(event -> {
            if(num >= 0 && num <= 5) {
                if ((number.indexOf(24)) == -1) {
                    number.add(24);
                    text_user.setText(String.valueOf(number));
                    num += 1;
                } else
                    status.setText("Число уже есть!");
            }else
                status.setText("Вы выбрали уже 6 чисел.");
        });
        button_25.setOnAction(event -> {
            if(num >= 0 && num <= 5) {
                if ((number.indexOf(25)) == -1) {
                    number.add(25);
                    text_user.setText(String.valueOf(number));
                    num += 1;
                } else
                    status.setText("Число уже есть!");
            }else
                status.setText("Вы выбрали уже 6 чисел.");
        });
        button_26.setOnAction(event -> {
            if(num >= 0 && num <= 5) {
                if ((number.indexOf(26)) == -1) {
                    number.add(26);
                    text_user.setText(String.valueOf(number));
                    num += 1;
                } else
                    status.setText("Число уже есть!");
            }else
                status.setText("Вы выбрали уже 6 чисел.");
        });
        button_27.setOnAction(event -> {
            if(num >= 0 && num <= 5) {
                if ((number.indexOf(27)) == -1) {
                    number.add(27);
                    text_user.setText(String.valueOf(number));
                    num += 1;
                } else
                    status.setText("Число уже есть!");
            }else
                status.setText("Вы выбрали уже 6 чисел.");
        });
        button_28.setOnAction(event -> {
            if(num >= 0 && num <= 5) {
                if ((number.indexOf(28)) == -1) {
                    number.add(28);
                    text_user.setText(String.valueOf(number));
                    num += 1;
                } else
                    status.setText("Число уже есть!");
            }else
                status.setText("Вы выбрали уже 6 чисел.");
        });
        button_29.setOnAction(event -> {
            if(num >= 0 && num <= 5) {
                if ((number.indexOf(29)) == -1) {
                    number.add(29);
                    text_user.setText(String.valueOf(number));
                    num += 1;
                } else
                    status.setText("Число уже есть!");
            }else
                status.setText("Вы выбрали уже 6 чисел.");
        });
        button_30.setOnAction(event -> {
            if(num >= 0 && num <= 5) {
                if ((number.indexOf(30)) == -1) {
                    number.add(30);
                    text_user.setText(String.valueOf(number));
                    num += 1;
                } else
                    status.setText("Число уже есть!");
            }else
                status.setText("Вы выбрали уже 6 чисел.");
        });
        button_31.setOnAction(event -> {
            if(num >= 0 && num <= 5) {
                if ((number.indexOf(31)) == -1) {
                    number.add(31);
                    text_user.setText(String.valueOf(number));
                    num += 1;
                } else
                    status.setText("Число уже есть!");
            }else
                status.setText("Вы выбрали уже 6 чисел.");
        });
        button_32.setOnAction(event -> {
            if(num >= 0 && num <= 5) {
                if ((number.indexOf(32)) == -1) {
                    number.add(32);
                    text_user.setText(String.valueOf(number));
                    num += 1;
                } else
                    status.setText("Число уже есть!");
            }else
                status.setText("Вы выбрали уже 6 чисел.");
        });
        button_33.setOnAction(event -> {
            if(num >= 0 && num <= 5) {
                if ((number.indexOf(33)) == -1) {
                    number.add(33);
                    text_user.setText(String.valueOf(number));
                    num += 1;
                } else
                    status.setText("Число уже есть!");
            }else
                status.setText("Вы выбрали уже 6 чисел.");
        });
        button_34.setOnAction(event -> {
            if(num >= 0 && num <= 5) {
                if ((number.indexOf(34)) == -1) {
                    number.add(34);
                    text_user.setText(String.valueOf(number));
                    num += 1;
                } else
                    status.setText("Число уже есть!");
            }else
                status.setText("Вы выбрали уже 6 чисел.");
        });
        button_35.setOnAction(event -> {
            if(num >= 0 && num <= 5) {
                if ((number.indexOf(35)) == -1) {
                    number.add(35);
                    text_user.setText(String.valueOf(number));
                    num += 1;
                } else
                    status.setText("Число уже есть!");
            }else
                status.setText("Вы выбрали уже 6 чисел.");
        });
        button_36.setOnAction(event -> {
            if(num >= 0 && num <= 5) {
                if ((number.indexOf(36)) == -1) {
                    number.add(36);
                    text_user.setText(String.valueOf(number));
                    num += 1;
                } else
                    status.setText("Число уже есть!");
            }else
                status.setText("Вы выбрали уже 6 чисел.");
        });
        button_37.setOnAction(event -> {
            if(num >= 0 && num <= 5) {
                if ((number.indexOf(37)) == -1) {
                    number.add(37);
                    text_user.setText(String.valueOf(number));
                    num += 1;
                } else
                    status.setText("Число уже есть!");
            }else
                status.setText("Вы выбрали уже 6 чисел.");
        });
        button_38.setOnAction(event -> {
            if(num >= 0 && num <= 5) {
                if ((number.indexOf(38)) == -1) {
                    number.add(38);
                    text_user.setText(String.valueOf(number));
                    num += 1;
                } else
                    status.setText("Число уже есть!");
            }else
                status.setText("Вы выбрали уже 6 чисел.");
        });
        button_39.setOnAction(event -> {
            if(num >= 0 && num <= 5) {
                if ((number.indexOf(39)) == -1) {
                    number.add(39);
                    text_user.setText(String.valueOf(number));
                    num += 1;
                } else
                    status.setText("Число уже есть!");
            }else
                status.setText("Вы выбрали уже 6 чисел.");
        });
        button_40.setOnAction(event -> {
            if(num >= 0 && num <= 5) {
                if ((number.indexOf(40)) == -1) {
                    number.add(40);
                    text_user.setText(String.valueOf(number));
                    num += 1;
                } else
                    status.setText("Число уже есть!");
            }else
                status.setText("Вы выбрали уже 6 чисел.");
        });
        button_41.setOnAction(event -> {
            if(num >= 0 && num <= 5) {
                if ((number.indexOf(41)) == -1) {
                    number.add(41);
                    text_user.setText(String.valueOf(number));
                    num += 1;
                } else
                    status.setText("Число уже есть!");
            }else
                status.setText("Вы выбрали уже 6 чисел.");
        });
        button_42.setOnAction(event -> {
            if(num >= 0 && num <= 5) {
                if ((number.indexOf(42)) == -1) {
                    number.add(42);
                    text_user.setText(String.valueOf(number));
                    num += 1;
                } else
                    status.setText("Число уже есть!");
            }else
                status.setText("Вы выбрали уже 6 чисел.");
        });
        button_43.setOnAction(event -> {
            if(num >= 0 && num <= 5) {
                if ((number.indexOf(43)) == -1) {
                    number.add(43);
                    text_user.setText(String.valueOf(number));
                    num += 1;
                } else
                    status.setText("Число уже есть!");
            }else
                status.setText("Вы выбрали уже 6 чисел.");
        });
        button_44.setOnAction(event -> {
            if(num >= 0 && num <= 5) {
                if ((number.indexOf(44)) == -1) {
                    number.add(44);
                    text_user.setText(String.valueOf(number));
                    num += 1;
                } else
                    status.setText("Число уже есть!");
            }else
                status.setText("Вы выбрали уже 6 чисел.");
        });
        button_45.setOnAction(event -> {
            if(num >= 0 && num <= 5) {
                if ((number.indexOf(45)) == -1) {
                    number.add(45);
                    text_user.setText(String.valueOf(number));
                    num += 1;
                } else
                    status.setText("Число уже есть!");
            }else
                status.setText("Вы выбрали уже 6 чисел.");
        });
        button_46.setOnAction(event -> {
            if(num >= 0 && num <= 5) {
                if ((number.indexOf(46)) == -1) {
                    number.add(46);
                    text_user.setText(String.valueOf(number));
                    num += 1;
                } else
                    status.setText("Число уже есть!");
            }else
                status.setText("Вы выбрали уже 6 чисел.");
        });
        button_47.setOnAction(event -> {
            if(num >= 0 && num <= 5) {
                if ((number.indexOf(47)) == -1) {
                    number.add(47);
                    text_user.setText(String.valueOf(number));
                    num += 1;
                } else
                    status.setText("Число уже есть!");
            }else
                status.setText("Вы выбрали уже 6 чисел.");
        });
        button_48.setOnAction(event -> {
            if(num >= 0 && num <= 5) {
                if ((number.indexOf(48)) == -1) {
                    number.add(48);
                    text_user.setText(String.valueOf(number));
                    num += 1;
                } else
                    status.setText("Число уже есть!");
            }else
                status.setText("Вы выбрали уже 6 чисел.");
        });
        button_49.setOnAction(event -> {
            if(num >= 0 && num <= 5) {
                if ((number.indexOf(40)) == -1) {
                    number.add(40);
                    text_user.setText(String.valueOf(number));
                    num += 1;
                } else
                    status.setText("Число уже есть!");
            }else
                status.setText("Вы выбрали уже 6 чисел.");
        });
    }
}