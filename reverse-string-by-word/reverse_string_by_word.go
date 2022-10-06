package main

import "strings"

//public static String reverseStringByWord(String input){
//char[] arr = input.toCharArray();
//String word = "";
//StringBuilder result = new StringBuilder();
//int end = input.length() - 1;
//int start = end - 1;
//while(start >= 0 && end >=0) {
//if(arr[end] == ' ') {
//end--;
//start = end - 1;
//continue;
//}
//if(arr[start] != ' ') {
//start--;
//continue;
//}
//word = String.valueOf(Arrays.copyOfRange(arr, start+1, end+1));
//end = start-1;
//start--;
//result.append(" ").append(word);
//}
//if(end >= 0 ) {
//result.append(" ").append(String.valueOf(Arrays.copyOfRange(arr, 0, end+1)));
//}
//return result.substring(1);
//}
func reverseStringByWord(input string) string {
	word := ""
	result := strings.Builder{}
	end := len(input) - 1
	start := end - 1
	for start >= 0 && end >= 0 {
		if input[end] == ' ' {
			end--
			start = end - 1
			continue
		}
		if input[start] != ' ' {
			start--
			continue
		}
		word = input[start+1 : end+1]
		end = start - 1
		start--
		result.Write([]byte((" " + word)))

	}
	if end >= 0 {
		result.Write([]byte(" " + input[0:end+1]))
	}
	return result.String()[1:]
}

func main() {
	println(reverseStringByWord("i am rehman"))
	println(reverseStringByWord("this is  mz    "))
	println(reverseStringByWord("this is      mz"))
}
