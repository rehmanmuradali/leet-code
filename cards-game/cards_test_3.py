import random

SUITS = ("♠", "♣", "♥", "♦")
RANKS = ("1", "2", "3", "4", "5", "6","7", "8", "9", "10", "J", "Q", "K", "A")
RANK_VALUE = {"1": 1, "2": 2, "3": 3, "4": 4, "5": 5, "6": 6,"7": 7, "8": 8, "9": 9, "10": 10, "J": 11, "Q": 12, "K": 13, "A": 14}
SCORES = {"5": 5, "10": 10, "K": 10}

NUMBER_OF_PLAYERS = 4
NUMBER_OF_ROUND = 13

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
		self.cards = [Card(suit, rank) for suit in SUITS for rank in RANKS]

	def shuffle(self):
		random.shuffle(self.cards)

	def show_deck(self):
		return " ".join(str(card) for card in self.cards)

	def draw_card(self):
		if not self.cards:
			raise RuntimeError("no cards left to draw from deck")
		return self.cards.pop()

	def __len__(self):
		return len(self.cards)

class Player:
	def __init__(self, name):
		self.name = name
		self.hand = []
		self.score = 0

	def draw_card(self, deck):
		card = deck.draw_card()
		self.hand.append(card)
		print(f"{self.name} drew a card")

	def show_hand(self):
		self.sort_hand()
		return " ".join(str(card) for card in self.hand)

	def sort_hand(self):
		self.hand.sort(key = lambda card: (SUITS.index(card.suit), RANKS.index(card.rank)))

	def play_card(self, lead_suit):
		if not self.hand:
			raise RuntimeError(f"no card left to be players for {self.name}")

		if lead_suit:
			matching_suit_cards = [card for card in self.hand if card.suit == lead_suit]
			if matching_suit_cards:
				card = matching_suit_cards[0]
				self.hand.remove(card)
				return card
		return self.hand.pop()

	def add_scores(self, trick_cards):
		points = 0
		for card in trick_cards:
			points += SCORES.get(card.rank, 0)

		self.score += points
		return points



class Game:
	def __init__(self, deck, players):
		self.deck = deck
		self.players = players 

	def draw_cards(self):
		for round_number in range(NUMBER_OF_ROUND + 1):
			print(f"round number: {round_number}")
			for player in self.players:
				player.draw_card(self.deck)

	def show_player_hand(self):
		for player in self.players:
			print(f"{player.name}'s hand")
			print(f"{player.show_hand()}")


	def play(self):
		winner_player_index = 0
		for round_number in range(NUMBER_OF_ROUND):
			winner_player_index = self.play_trick(winner_player_index)
			

	def play_trick(self, starting_player_index):
		lead_suit = None
		trick_cards = []

		for offset in range (NUMBER_OF_PLAYERS):
			current_player_index = (starting_player_index + offset) % NUMBER_OF_PLAYERS
			current_player = self.players[current_player_index]
			card = current_player.play_card(lead_suit)
			print(f"{current_player.name} played {str(card)}")


			if not lead_suit:
				lead_suit = card.suit

			trick_cards.append(card)



		winner_card_index = self.determine_trick_winner_card_index(trick_cards, lead_suit)
		winner_player_index = (starting_player_index + winner_card_index) % NUMBER_OF_PLAYERS

		winner_player = self.players[winner_player_index]
		score = winner_player.add_scores(trick_cards)


		print(f"Trick winner: {winner_player.name} (Score: {score})")	
		return winner_player_index

	def determine_trick_winner_card_index(self, trick_cards, lead_suit):
		winner_card_index = 0
		winner_card = trick_cards[0]
		for index, card in enumerate(trick_cards):
			if card.suit == lead_suit and card.get_rank() > winner_card.get_rank():
				winner_card_index = index
				winner_card = card

		return winner_card_index




	def show_result(self):

		for player in self.players:
			print(f"{player.name}: (Score: {player.score})")


		game_winner_player = max(self.players, key = lambda player: player.score)

		print(f"WINNER:  {game_winner_player.name}")










def main():

	deck = Deck()
	deck.shuffle()

	print("Here's the shuffleed deck")
	print(f"{deck.show_deck()}")	


	players = []
	for i in range(1, NUMBER_OF_PLAYERS + 1):
		players.append(Player(f"Player {i}"))


	game = Game(deck, players)
	game.draw_cards()
	game.show_player_hand()


    # assertions

	assert len(deck) == 0 

	all_cards = []
	for player in players:
		all_cards += player.hand
	
	assert len(all_cards) == len(set(all_cards))



	game.play()
	game.show_result()


if __name__ == "__main__":
    main()
