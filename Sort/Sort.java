package Sort;
//Задание №7
//Отсортируйте массив по частоте элементов: то есть, элементы, которые имеют более высокую частоту, должны находиться на первом месте.
// Если частоты двух элементов одинаковы, то меньшее число идет первым. Для решения этой задачи используйте хэш-таблицы
import java.util.*;

public class Sort {

    public static void main(String[] args)

    {
        int[] arr1 = new int[1000];
        Scanner scan = new Scanner(System.in);
        int input;
        String command;
        String exit = "end";
        int j = 0;
        boolean b = true;

        System.out.println("Вводите числа массива, после каждого наживая клавишу enter");
        System.out.println("В случае окончания ввода, введите команду end");

        while (b)
        {
            command = scan.nextLine();
            if (command.equals(exit))    {b=false;} else {

                input = Integer.valueOf(command);
                arr1[j] = input;
                ++j;

            }


        }

        scan.close();


        int[] array = new int[j];

        for(int k=0;k<j;k++){
            array[k]=arr1[k];
        }


        System.out.println("Сортированный по частоте элементов массив:");
        System.out.println("");


        Map<Integer, Integer> map = new HashMap<>();

        List<Integer> outputArray = new ArrayList<>();


        for (int current : array) {

            int count = map.getOrDefault(current, 0);

            map.put(current, count + 1);

            outputArray.add(current);

        }


        SortComparator comp = new SortComparator(map);


        Collections.sort(outputArray, comp);


        for (Integer i : outputArray) {

            System.out.print(i + " ");

        }

    }

}


class SortComparator implements Comparator<Integer> {

    private final Map<Integer, Integer> freqMap;

    SortComparator(Map<Integer, Integer> tFreqMap)

    {

        this.freqMap = tFreqMap;

    }



    @Override

    public int compare(Integer k1, Integer k2)

    {
        int freqCompare = freqMap.get(k2).compareTo(freqMap.get(k1));


        int valueCompare = k1.compareTo(k2);


        if (freqCompare == 0)

            return valueCompare;

        else

            return freqCompare;

    }

}
