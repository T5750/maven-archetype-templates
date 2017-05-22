package com.shekhar.dictionary;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import java.util.List;

import javax.inject.Inject;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shekhar.dictionary.config.LocalRedisConfig;
import com.shekhar.dictionary.dao.DictionaryDao;

@ContextConfiguration(classes = { LocalRedisConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class DictionaryDaoTest {
	@Inject
	private DictionaryDao dictionaryDao;
	@Inject
	private StringRedisTemplate redisTemplate;

	@After
	public void tearDown() {
		redisTemplate.getConnectionFactory().getConnection().flushDb();// 仅删除当前数据库中的键
	}

	@Test
	public void testAddWordWithItsMeaningToDictionary() {
		String meaning = "To move forward with a bounding, drooping motion.";
		Long index = dictionaryDao.addWordWithItsMeaningToDictionary("lollop",
				meaning);
		assertThat(index, is(notNullValue()));
		assertThat(index, is(equalTo(1L)));
	}

	@Test
	public void shouldAddMeaningToAWordIfItExists() {
		Long index = dictionaryDao.addWordWithItsMeaningToDictionary("lollop",
				"To move forward with a bounding, drooping motion.");
		assertThat(index, is(notNullValue()));
		assertThat(index, is(equalTo(1L)));
		index = dictionaryDao.addWordWithItsMeaningToDictionary("lollop",
				"To hang loosely; droop; dangle.");
		assertThat(index, is(equalTo(2L)));
	}

	private void setupOneWord() {
		String meaning = "To move forward with a bounding, drooping motion.";
		Long index = dictionaryDao.addWordWithItsMeaningToDictionary("lollop",
				meaning);
	}

	@Test
	public void shouldGetAllTheMeaningForAWord() {
		setupOneWord();
		List<String> allMeanings = dictionaryDao
				.getAllTheMeaningsForAWord("lollop");
		assertThat(allMeanings.size(), is(equalTo(2)));
		// assertThat(allMeanings,
		// hasItems("To move forward with a bounding, drooping motion.",
		// "To hang loosely; droop; dangle."));
	}

	@Test
	public void shouldDeleteAWordFromDictionary() throws Exception {
		setupOneWord();
		dictionaryDao.removeWord("lollop");
		List<String> allMeanings = dictionaryDao
				.getAllTheMeaningsForAWord("lollop");
		assertThat(allMeanings.size(), is(equalTo(0)));
	}

	@Test
	public void shouldDeleteMultipleWordsFromDictionary() {
		setupTwoWords();
		dictionaryDao.removeWords("fain", "lollop");
		List<String> allMeaningsForLollop = dictionaryDao
				.getAllTheMeaningsForAWord("lollop");
		List<String> allMeaningsForFain = dictionaryDao
				.getAllTheMeaningsForAWord("fain");
		assertThat(allMeaningsForLollop.size(), is(equalTo(0)));
		assertThat(allMeaningsForFain.size(), is(equalTo(0)));
	}

	private void setupTwoWords() {
		Long index = dictionaryDao.addWordWithItsMeaningToDictionary("fain",
				"fain fain");
		index = dictionaryDao.addWordWithItsMeaningToDictionary("lollop",
				"lollop fain");
	}
}