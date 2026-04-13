import random
from dataclasses import dataclass

suits = ("♠", "♣", "♥", "♦")
RANKS = ("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A")
RANK_VALUE = {"2": 2, "3": 3, "4": 4, "5": 5, "6": 6, "7": 7, "8": 8, "9": 9, "10": 10, "J": 11, "Q": 12, "K": 13, "A": 14}
TRICK_POINTS = {"5": 5, "10": 10, "K": 10}
CARDS_PER_PLAYER = 13

class Card:

    def __init__(self, suit, rank):
        self.suit = suit
        self.rank = rank

    def __str__(self):
        return f"{self.rank}{self.suit}"

    def get_rank(self):
        return RANK_VALUE[self.rank]


class Deck:
    def __init__(self):
        self.cards = [Card(suit, rank) for suit in suits for rank in RANKS]

    def __str__(self):
        return " ".join(str(card) for card in self.cards)

    def shuffle(self):
        random.shuffle(self.cards)

    def draw(self):
        if not self.cards:
            raise RuntimeError("Deck Is Empty")
        return self.cards.pop()

    def __len__(self):
        return len(self.cards)


class Player:
    def __init__(self, name):
        self.name = name
        self.hand = []
        self.score = 0


    def draw_card(self, deck):
        card = deck.draw()
        self.hand.append(card)

    def __str__(self):
        return f"{self.name}'s hand: " + " ".join(str(card) for card in self.hand)

    def sort_hand(self):
        #self.hand = [card for suit in suits for card in self.hand if card.suit == suit]
        self.hand.sort(key= lambda card: (suits.index(card.suit), RANKS.index(card.rank)))


    def play_card(self, lead_suit: str | None):
        if not self.hand:
            raise RuntimeError(f"{self.name} has no cards")

        if lead_suit:
            matching = [c for c in self.hand if c.suit == lead_suit]
            if matching:
                card = matching[0] 
                self.hand.remove(card)
                return card

        return self.hand.pop()

    def add_trick_points(self, trick):
        score = 0
        for card in trick:
            score += TRICK_POINTS.get(card.rank, 0)

        self.score += score
        return score


class Game:

    def __init__(self, deck, players):
        self.deck = deck
        self.players = players
        self.current_leader_index = 0

    def draw_cards(self):
        turn = 0
        while len(self.deck.cards) > 0:
            player = self.players[turn%len(self.players)]
            player.draw_card(self.deck)
            print(f"{player.name} drew a card")
            turn = turn + 1


    def print_sorted_hands(self):
        for player in self.players:
            player.sort_hand()
            print(player)

    def play(self):
        for round_no in range(1, CARDS_PER_PLAYER + 1):
            self.play_trick()


    def play_trick(self):
        trick_cards: Card = []
        leading_suit = None
        player_with_max_card = None
        card_on_table = None
        max_card = None
        current_player_index = self.current_leader_index

        for i in range (current_player_index, current_player_index + len(self.players)):
            next_player_index = i%len(self.players)
            played_card = self.players[next_player_index].play_card(leading_suit)
            if (leading_suit == None):
                leading_suit = played_card.suit
                player_with_max_card = current_player_index
                max_card = played_card

            print(f"{self.players[next_player_index].name} played: {str(played_card)}")
            trick_cards.append(played_card)
            if (played_card.suit == leading_suit and max_card.get_rank() < played_card.get_rank()):
                player_with_max_card = next_player_index
                max_card = played_card
                self.current_leader_index = next_player_index

        print(f"Trick Winner: {self.players[player_with_max_card].name} (Score: {self.players[player_with_max_card].add_trick_points(trick_cards)})") 

    def print_scores(self):

        for player in self.players:
            print(f"{player.name}: {player.score}")

        print(f"Winner {max(self.players, key = lambda player: player.score).name}")



def main():
    deck = Deck()
    print("Here's the shuffle deck")
    deck.shuffle()
    print(deck)

    player1 = Player("Player1")
    player2 = Player("Player2")
    player3 = Player("Player3")
    player4 = Player("Player4")


    players = [player1, player2, player3, player4]

    game =Game(deck, players)
    game.draw_cards()


    visited = set()
    for player in game.players:
        for card in player.hand:
            if card in visited:
                assert card not in visited
            visited.add(card)


    allCards = []
    for player in players:
        allCards += player.hand

    assert len(allCards) == len(set(allCards))

    assert len(game.deck.cards) == 0

    game.print_sorted_hands()
    game.play()
    game.print_scores()




if __name__ == "__main__":
    main()
