package main

func main() {

	baracoda := Baracoda{
		AliveCreator{
			Strength: 10,
		},
	}
	human := Human{
		AliveCreator{
			Strength: 20,
		},
	}
	shark := Shark{
		AliveCreator{
			Strength: 30,
		},
	}

	baracoda.Bite(human.AliveCreator)
	human.Bite(shark.AliveCreator)

}

type LivingCreator interface {
	Bite(d DamageTaker)
	CanBite(prey AliveCreator) []string
	IsDead() bool
}

type DamageTaker interface {
	TakeDamage()
}

type Baracoda struct {
	AliveCreator
}

func (b Baracoda) Bite(prey AliveCreator) {
	if b.CanBite(prey) {
		b.TakeDamage()
	}

}
func (b Baracoda) CanBite(prey AliveCreator) bool {
	return true
}

func (b Baracoda) IsDead() bool {
	return b.Strength == 0
}

//--------

type AliveCreator struct {
	Strength int
}

func (a AliveCreator) TakeDamage() {
	//TODO implement me
	a.Strength -= 10
}

type Human struct {
	AliveCreator
}

type Shark struct {
	AliveCreator
}

// --------------

//  -------------------------

func (h Human) Bite(prey AliveCreator) {
	//TODO implement me
	panic("implement me")
}

func (h Human) CanBite() []string {
	//TODO implement me
	panic("implement me")
}

func (h Human) IsDead() bool {
	//TODO implement me
	panic("implement me")
}

func (s Shark) Bite() {
	//TODO implement me
	panic("implement me")
}

func (s Shark) CanBite() []string {
	//TODO implement me
	panic("implement me")
}

func (s Shark) IsDead() bool {
	//TODO implement me
	panic("implement me")
}

//  -------

type Gunner interface {
	Shot(entity LivingCreator)
}
