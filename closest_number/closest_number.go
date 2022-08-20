package main

import (
	"fmt"
	"math"
	"sort"
)

//public void closestNumbers(List<int> numbers)
//{
//numbers.Sort();
//var lowestDiff = Math.Abs(numbers[1] - numbers[0]);
//List<int> result = new List<int> {numbers[0], numbers[1]};
//
//for (int i = 1; i < numbers.Count-1; i++)
//{
//if (Math.Abs(numbers[i + 1] - numbers[i]) < lowestDiff)
//{
//result.RemoveAll(x => true);
//result.Add(numbers[i]);
//result.Add(numbers[i + 1]);
//lowestDiff = Math.Abs(numbers[i + 1] - numbers[i]);
//} else if (Math.Abs(numbers[i + 1] - numbers[i]) == lowestDiff)
//{
//result.Add(numbers[i]);
//result.Add(numbers[i + 1]);
//}
//}
//
//var index = 0;
//while (index < result.Count-1)
//{
//if (index % 2 == 0)
//{
//if (index + 1 >= 0)
//Console.WriteLine($"{result[index]} {result[index + 1]}");
//}
//index++;
//}
//}
type byValue []int32

func (f byValue) Len() int {
	return len(f)
}

func (f byValue) Less(i, j int) bool {
	return f[i] < f[j]
}

func (f byValue) Swap(i, j int) {
	f[i], f[j] = f[j], f[i]
}

func closestNumbers(numbers []int32) {
	sort.Sort(byValue(numbers))
	//sort.Slice(numbers, func(i, j int) bool { return numbers[i] < numbers[j] })
	//fmt.Printf("%v", numbers)
	var lowestDiff = math.Abs(float64(numbers[1] - numbers[0]))
	var result []int32

	result = append(result, numbers[0])
	result = append(result, numbers[1])

	//result[0] = numbers[0]
	//result[1] = numbers[1]

	for i := 1; i < len(numbers)-1; i++ {
		if math.Abs(float64(numbers[i+1]-numbers[i])) < lowestDiff {
			result[0] = numbers[i]
			result[1] = numbers[i+1]
			lowestDiff = math.Abs(float64(numbers[i+1] - numbers[i]))
		} else if math.Abs(float64(numbers[i+1]-numbers[i])) == lowestDiff {
			result = append(result, numbers[i])
			result = append(result, numbers[i+1])
		}
	}
	var index = 0
	for index < len(result)-1 {
		fmt.Printf("%d %d \n", result[index], result[index+1])
		index += 2
	}

}

func main() {
	q := []int32{4, 2, 1, 5}
	closestNumbers(q)
}
