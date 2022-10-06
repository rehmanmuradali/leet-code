package main

import (
	"fmt"
)

const a = "12"

//import "fmt"

//func main() {
//	items := []string{"zero", "one", "two", "three"}
//	result := make(map[int]string)
//
//	lock := sync.Mutex{}
//	done := make(chan bool)
//	for i, item := range items {
//		go func(i int, item string, done chan<- bool) {
//			lock.Lock()
//			defer lock.Unlock()
//			result[i] = item
//			done <- true
//		}(i, item, done)
//	}
//
//	for i := 0; i < len(items); i++ {
//		<-done
//	}
//
//	fmt.Printf("%#v\n", result)
//}

//func main() {
//	items := []string{"zero", "one", "two", "three"}
//	result := make(map[int]string)
//	wg := sync.WaitGroup{}
//	lock := sync.Mutex{}
//	wg.Add(len(items))
//	for i, item := range items {
//		go func(i int, item string) {
//			lock.Lock()
//			defer lock.Unlock()
//			result[i] = item
//			wg.Done()
//		}(i, item)
//	}
//	wg.Wait()
//	fmt.Printf("%#v\n", result)
//}

var errorsMap = map[string]interface{}{
	"customer": map[string]interface{}{
		"email": "invalid email address",
	},
	"country": "invalid country code",
	"order": map[string]interface{}{
		"payment": map[string]interface{}{
			"currency": "currency cannot be blank",
		},
		"id": "invalid format for order id",
	},
}

func main() {
	src := make([]int, 2, 10)
	dest := []int{1, 2, 3, 4, 5, 6}

	n := copy(src, dest[:])
	src = append(src[1:2], src[2:4]...)
	src = append(src, 4)

	fmt.Printf("n: %d, src: %v", n, src)

	//display the flattened version of `errorsMap`
	var result = map[string]string{}
	parseError(errorsMap, "", result)

}

func parseError(errorMap map[string]interface{}, parent string, result map[string]string) {
	for k, v := range errorMap {
		switch value := v.(type) {
		case string:
			key := fmt.Sprintf("%s", k)
			if parent != "" {
				key = fmt.Sprintf("%s.%s", parent, k)
			}
			result[key] = value
		default:
			newErrMap, ok := v.(map[string]interface{})
			if !ok {
				return
			}

			parseError(newErrMap, k, result)
		}
	}
}

//var errorsMap = map[string]any {
//   "customer": map[string]any {
//     "email": "invalid email address",
//   },x
//   "country": "invalid country code",
//   "order": map[string]any{
//     "payment": map[string]any {
//       "currency": "currency cannot be blank",
//     },
//     "id": "invalid format for order id",
//   },
// }

//  key -> parent
//  tracverse all keys -> parent.currentKey  -> value is string type-> push into map
//  tracverse all keys -> parent.currentKey  -> value is map type -> call the func again with new parent key

//func main3() {
//	// display the flattened version of `errorsMap`
//
//	var result = map[string]string{}
//	parseError(errorsMap, "", result)
//	fmt.Printf("%#v", result)
//}

//var errorsMap = map[string]any {
//   "customer": map[string]any {
//     "email": "invalid email address",
//   },
//   "country": "invalid country code",
//   "order": map[string]any{
//     "payment": map[string]any {
//       "currency": "currency cannot be blank",
//     },
//     "id": "invalid format for order id",
//   },
// }

//  key -> parent
//  tracverse all keys -> parent.currentKey  -> value is string type-> push into map
//  tracverse all keys -> parent.currentKey  -> value is map type -> call the func again with new parent key

// order.payment.currency
// .currency
//

