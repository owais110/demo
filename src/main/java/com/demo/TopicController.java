package com.demo;

import java.util.List;
import java.util.Set;

import org.apache.catalina.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class TopicController {

	@RequestMapping("/topics")
	public List<Topic> getTopics() {
		return Arrays.asList(new Topic("1", "Spring Framework", "Spring Framework"),
				new Topic("2", "Java Course", "Java Course Description"),
				new Topic("3", "Node JS", "Node JS Description"));
	}

	@RequestMapping(value = "/topics", method = RequestMethod.POST)
	public String addMessage(@RequestParam(value = "name") String name) {

		System.out.println(name);
		return "Post Sucessfuly " + name;
	}

	@RequestMapping(value = "/topics", method = RequestMethod.DELETE)
	public String deleteMessage(@RequestParam(value = "id") String id) {

		System.out.println(id);
		return "Deleted Sucessfuly " + id;
	}

	@RequestMapping(value = "/topics/{id}", method = RequestMethod.PUT)
	public @ResponseBody Topic updateTopics(@PathVariable("id") String id, @RequestBody Topic topic) {
		System.out.println("................" + id);
		return topic;

	}
}