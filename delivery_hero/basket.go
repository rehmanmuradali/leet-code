package main

type item struct {
	ID       int
	unitType int
	name     string
}

type BASKET struct {
	ID    int
	items []item
}

//Func getBasketAmount(Discount d){
//getDiscount()
//}
//
//// Get from input  -> []Discount{}
//DISCOUNT {
//[]ITEM_DISCOUNT-> ARRAY IF THAT EXITS
//DISCOUNT -> percentage
//}
//ITEM_DISCOUNT {
//ITEMID
//CUT_OFF -> WEIGHT/COUNT
//}
//DISCOUNT USER SE INPUT LE AND TRAVESE KAR
