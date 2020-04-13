package com.zemoso.songApp.service.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.zemoso.songApp.DAO.SongRepository;
import com.zemoso.songApp.entity.Song;
import com.zemoso.songApp.service.SongServiceImplementation;


@RunWith(SpringRunner.class)
@SpringBootTest
class SongServiceTest {


	// We are mocking the Repository : As hitting the Database for testing isn't efficient .
	// Mocking means we have to create a list or collection of data which is similar to the data in database.

	@MockBean
	private SongRepository songRepo;


	// Injecting the repository into service.
	@Autowired
	private SongServiceImplementation songService;


	// This list will work like repository
	List<Song> list= new ArrayList<Song>();

//	@Before
//	public void init() {
//		
//		
//		Song s1 = new Song(1,"Shape of You","Ed Sheeran");
//		Song s2 = new Song(2,"Perfect","Ed Sheeran");
//		Song s3 = new Song(3,"Nights","Avicii");
//		
//		list.add(s1);
//		list.add(s2);
//		list.add(s3);
//
//		
//	}

	// Testing each method of our Service.

	@Test
	public void findAllTest() {
		

		Song s1 = new Song(1,"Shape of You","Ed Sheeran");
		Song s2 = new Song(2,"Perfect","Ed Sheeran");
		Song s3 = new Song(3,"Nights","Avicii");
		
		list.add(s1);
		list.add(s2);
		list.add(s3);
		
		//Mocking 
		Mockito.when(songRepo.findAll()).thenReturn(list);
		
		//Test
		
		List<Song> songsList = songService.findAll();
		
		assertEquals(3,songsList.size());
		
	}

	
	@Test
	public void findByIdTest() {
		
		Song theSong = new Song(4,"Abc","xyz");
		
		Mockito.when(songRepo.findById(theSong.getId())).
			thenReturn(Optional.of(theSong));
		
		assertEquals(theSong,songService.findById(theSong.getId()));
	}

	@Test
	public void findByFavourite() {
		
		Song s1 = new Song(1,"Shape of You","Ed Sheeran","YES");
		Song s2 = new Song(2,"Perfect","Ed Sheeran","YES");
		Song s3 = new Song(3,"Nights","Avicii","YES");
		
		list.add(s1);
		list.add(s2);
		list.add(s3);
		
		//Mocking 
		Mockito.when(songRepo.findByFavourite("YES")).thenReturn(list);
		
		List<Song> favSongsList = songService.findByFavourite("YES");
		
		assertEquals(3,favSongsList.size());
	}
	
	@Test
	public void saveTest() {
	
		Song theSong = new Song(5,"Abc","xyz");
		
		Mockito.when(songRepo.save(theSong)).thenReturn(theSong);
		
		assertEquals(theSong,songService.save(theSong));
		
	}

	@Test
	public void deleteTest() {
		
		Song theSong = new Song(6,"Abc","xyz");
		
		songService.deleteById(theSong.getId());
		
		Mockito.verify(songRepo,Mockito.times(1)).deleteById(theSong.getId());;
		
	}

}


