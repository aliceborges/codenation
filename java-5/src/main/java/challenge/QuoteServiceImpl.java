package challenge;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuoteServiceImpl implements QuoteService {

	@Autowired
	private QuoteRepository repository;
	
	Random random = new Random();
	
	@Override
	public Quote getQuote() {
		return repository.findQuote();
	}

	@Override
	public Quote getQuoteByActor(String actor) {
		List<Quote> quotes = repository.findByActor(actor);
		
		if (!quotes.isEmpty())
			return quotes.get(this.random.nextInt(quotes.size()));
		return null;
	}

}
