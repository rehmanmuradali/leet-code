import random

SUITS = ("S", "C", "H", "D")
RANKS = ("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A")
RANK_VALUE = {"2": 1, "3": 2, "4": 3, "5": 4, "6":5, "7": 6, "8":7, "9":8, "10": 9, "J": 10, "Q": 11, "K": 12, "A": 13}
NUMBER_OF_PLAYERS = 4
NUMBER_OF_ROUNDS = 13

SCORES = {"5": 5, "10": 10, "K": 10}


class Card:
    def __init__(self, suit, rank):
        self.suit = suit
        self.rank = rank

    def  __str__(self):
        return f"{self.rank}{self.suit}"


    def get_rank(self):
        return RANK_VALUE[self.rank]



class Deck:
    def __init__(self):
        self.cards = [Card(suit, rank) for suit in SUITS for rank in RANKS]

    def shuffle(self):
        random.shuffle(self.cards)

    def __str__(self):
        return " ".join(str(card) for card in self.cards)

    def draw_card(self):
        return self.cards.pop()

    def __len__(self):
        return len(self.cards)


class Player:
    def __init__(self, name):
        self.name = name
        self.hand = []
        self.score = 0

    def receive_card(self, deck):
        if not deck.cards:
            raise RuntimeError("no card left in deck to be drawn")
        self.hand.append(deck.draw_card())

    def sort_hand(self):
        self.hand.sort(key = lambda card: (SUITS.index(card.suit), RANKS.index(card.rank)))

    def show_hand(self):
        self.sort_hand()
        return " ".join(str(card) for card in self.hand)


    def play_card(self, leading_suit):
        if not self.hand:
            raise RuntimeError("no playing card left")

        if leading_suit:
            matching_suit_cards = [card for card in self.hand if card.suit == leading_suit]
            if matching_suit_cards:
                card = matching_suit_cards[0]
                self.hand.remove(card)
                return card

        return self.hand.pop()


    def add_trick_points(self, tricks):
        points = 0
        for card in tricks:
            points += SCORES.get(card.rank, 0)
        self.score += points

        return points


class Game:

    def __init__(self, deck, players):
        self.deck = deck
        self.players = players


    def draw_cards(self):
        self.deck.shuffle()
        print(f"Here's the shuffled deck")
        print(f"{str(self.deck)}")

    def show_player_hands(self):
        for player in self.players:
            print(f"{player.name}'s hand")
            print(f"{player.show_hand()}")

    def distribute_cards(self):
        for round_no in range(1, NUMBER_OF_ROUNDS + 1):
            for player in self.players:
                player.receive_card(self.deck)
                print(f"{player.name} drew  a card")

    def start(self):

        winner_player_index = 0
        for round in range (1, NUMBER_OF_ROUNDS + 1):
            winner_player_index = self.play_trick(winner_player_index)



    def play_trick(self, starting_player):

        leading_suit = None 
        trick_cards = []

        for offset in range (NUMBER_OF_PLAYERS):
            current_player_index = (starting_player + offset)%NUMBER_OF_PLAYERS
            current_player = self.players[current_player_index]
            card = current_player.play_card(leading_suit)
            print(f"{current_player.name} played {str(card)}")

            if not leading_suit:
                leading_suit = card.suit

            trick_cards.append(card)


        winner_card_index = self.determine_trick_winner(trick_cards, leading_suit)
        winner_player_index = (starting_player + winner_card_index)%NUMBER_OF_PLAYERS

        winner_player = self.players[winner_player_index]
        score = winner_player.add_trick_points(trick_cards)

        print(f"Trick Winner: {self.players[winner_player_index].name} (Score: {score})")
        return winner_player_index

    def determine_trick_winner(self, tricks, leading_suit):
        winer_card = tricks[0]
        winner_card_index = 0
        for index,card in enumerate(tricks):
            if card.suit == leading_suit and card.get_rank() > winer_card.get_rank():
                winner_card_index = index
                winer_card = card
        return winner_card_index


    def show_results(self):

        for player in self.players:
            print(f"{player.name}: (Score: {player.score})")

        winner = max(self.players, key = lambda player: player.score)

        print(f"WINNER: {winner.name}")

                

def main():
    deck = Deck()
    
    players = []
    for i in range (1, NUMBER_OF_PLAYERS + 1):
        players.append(Player(f"Player {i}"))


    game = Game(deck ,players)
    game.draw_cards()
    game.distribute_cards()
    game.show_player_hands()



    # # assertions before game starts
    # assert len(deck) == 0
    # all_cards = []
    # for player in players:
    #     all_cards += player.hand

    # assert len(all_cards) == len(set(all_cards))

    # for player in players:
    #     assert len(player.hand) == NUMBER_OF_ROUNDS




    game.start()
    game.show_results() 






if __name__ == "__main__":
    main()

