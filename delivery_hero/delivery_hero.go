package main

func combineTwoStructs() []map[string]int {

	var category []map[string][]string
	category = append(category, map[string][]string{"Product2": []string{"tag1", "tag2", "tag3"}})
	category = append(category, map[string][]string{"Product1": []string{"tag1", "tag3"}})

	customerPrefSlice := map[string]int{"tag1": 20, "tag2": 50, "tag3": 10}

	var finalPoints []map[string]int

	for _, cat := range category {
		output := map[string]int{}
		for name, tags := range cat {
			for _, tag := range tags {
				output[name] = output[name] + customerPrefSlice[tag]
			}
		}
		finalPoints = append(finalPoints, output)
	}
	return finalPoints
}

func main() {
	combineTwoStructs()
}
