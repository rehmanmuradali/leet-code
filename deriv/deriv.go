package main

import (
	"bufio"
	"fmt"
	"log"
	"os"
	"strconv"
	"strings"
	"time"
)

// Time      Time     Ask     Bid    Market    Stock
//  00:00:00  00:00   109.09 109.095 109.093    FXCM

//  // 1. Eliminate Storing 2nd field, as it is generated from 1st
//  // 2. Keep 1st field in seconds of the day, at max it will be 60*60*24= 85400 seconds
//                 Use time difference instead of actual time
//  // 3. Against each stock -> Avoid new lines and use separaters like ';' to reduce file size
//  // 4. Stored By stock to avoid writing consecutive stocks entries
//         (Additional: Can map each stock to bit value)

//     5. Format to save: Stock:secondsOftheDay,Ask,Bid,Market;

//     6. How to save if we have consecutive stocks only difference in values
//         use a separate separaters to separate for same stock values eg '-'
//         Example:
//         00:00:00 00:00 109.09 109.095 109.093 FXCM
//         00:00:01 00:00 109.086 109.09 109.088 FXCM
//         00:00:02 00:00 109.076 109.083 109.079 DUBA

//         will be
//         FXCM:0,109.09,109.095,109.093-1,109.086,109.09,109.088;DUBA:1,109.076,109.083,109.079
// -------------------
/// Benchmarking:
// Eliminated Field 2 -> Saved n field number 2 space, where 7 *n is number of rows and 7 is num of characters required to store
// Eliminated n new line characters
// Time field is reduced to max 2 characters as difference between previous and current time will not be greater then that
// Previous = 8 characters , now = 2 characters => saved 6 *n characters
// Considering each stock value will be n/10 time in consecutive (Assuming):
//      This will save storing same stock n/10 time
//      Stock value is 4 characters => saved => n/10*4 characters

// Total Saved := n + n + 6*n + n/10*4
//
func main() {

	// 	Read file test.txt
	// 	Write file compressed.txt

	file, err := os.Open("test1.txt")
	defer file.Close()

	if err != nil {
		log.Fatal(err)
	}
	scanner := bufio.NewScanner(file)
	layout := "01:01:01"
	// Keep track of previous stock to compress further
	prevStock := ""
	// keep track of previous time to store only difference
	prevTimeInSeconds := 0
	compressedResult := ""
	// Read file line by line
	for scanner.Scan() {
		line := scanner.Text()
		// For each line split the string by spaces, separating each field
		parts := strings.Split(line, " ")
		// Read time in format "HH:mm:ss" and save seconds in timeInSecondsVariable
		t, _ := time.Parse(layout, parts[0])
		timeInSeconds := t.Second()
		// Read relevant field and convert it to float
		askPrice, _ := strconv.ParseFloat(parts[2], 32)
		bidPrice, _ := strconv.ParseFloat(parts[3], 32)
		marketPrice, _ := strconv.ParseFloat(parts[4], 32)
		stock := parts[5]

		// For each line apply two cases:
		// 1. If previous stock was same then
		//          separate it via "-" delimiter and save new entry
		// 2. If it is not same then seperate it via ';' delimeter and save new stock and new prices
		lineToCompress := ""
		if stock == prevStock {
			lineToCompress = lineToCompress + "-"
		} else {
			lineToCompress = lineToCompress + ";" + stock + ":"
		}

		lineToCompress = lineToCompress + strconv.Itoa(timeInSeconds-prevTimeInSeconds) + ","
		lineToCompress = lineToCompress + fmt.Sprintf("%f", askPrice) + ","
		lineToCompress = lineToCompress + fmt.Sprintf("%f", askPrice-bidPrice) + ","
		lineToCompress = lineToCompress + fmt.Sprintf("%f", askPrice-marketPrice) + ","

		// update previous stock and time for next calculations
		prevTimeInSeconds = timeInSeconds
		prevStock = stock
		// After calculating, append result into final compressedResult string
		compressedResult = compressedResult + lineToCompress
		lineToCompress = ""

	}

	compressedResult = strings.TrimSuffix(compressedResult, ",")
	compressedResult = strings.TrimPrefix(compressedResult, ";")

	// Write compressedResult into file
	fmt.Printf(compressedResult)

	if scanner.Err() == bufio.ErrTooLong {
		log.Fatal(scanner.Err())
	}

}
