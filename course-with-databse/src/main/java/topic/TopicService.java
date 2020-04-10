package topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;
	
	private List<Topic> topics = new ArrayList<> (Arrays.asList(
    		new Topic("Spring", "Spring Framework", "Spring Framework Description"),
    		new Topic("Java", "Core Java", "Core Java Description"),
    		new Topic("Javascript", "JavaScript", "Javascript Description")
    		));
	
	public List<Topic> getAllTopic(){
		List<Topic> _topics = new ArrayList<>();
		topicRepository.findAll().forEach(_topics::add);
		return _topics;
	}
	
	public Topic getTopic(String id) {
	   return topicRepository.findById(id).get();
	}

	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}

	public void updateTopic(Topic topic, String id) {
		topicRepository.save(topic);
	}

	public void deleteTopic(String id) {
		topicRepository.deleteById(id);
	}
	
	
	
}
