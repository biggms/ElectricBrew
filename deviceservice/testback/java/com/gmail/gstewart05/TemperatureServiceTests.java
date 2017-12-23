package com.gmail.gstewart05;

import com.gmail.gstewart05.deviceservice.temperature.model.Temperature;
import com.gmail.gstewart05.deviceservice.temperature.model.TemperatureRepository;
import com.gmail.gstewart05.deviceservice.temperature.service.TemperatureServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

@RunWith( SpringRunner.class )
public class TemperatureServiceTests
{
	@Mock
	private TemperatureRepository theTemperatureRepository;

	@InjectMocks
	private TemperatureServiceImpl theOrgService;

	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks( this );
	}

	@Test
	public void testGetAll()
	{
		List< Temperature > lList = new ArrayList<>();
		lList.add( Temperature.builder().name( "Form 3" ).build() );
		lList.add( Temperature.builder().name( "Apple" ).build() );
		lList.add( Temperature.builder().name( "Samsung" ).build() );

		when( theTemperatureRepository.findAll() ).thenReturn( lList );

		List lResult = theOrgService.getAll();
		assertEquals( 3, lList.size() );

		verify( theTemperatureRepository, times( 1 ) ).findAll();
		verifyNoMoreInteractions( theTemperatureRepository );
	}

	@Test
	public void testGetById()
	{
		when( theTemperatureRepository.findOne( "1" ) ).thenReturn( Temperature.builder().id( "1" ).name( "Form 3" ).build() );

		Temperature lTemperature = theOrgService.getById( "1" );
		assertEquals( "1", lTemperature.getId() );
		assertEquals( "Form 3", lTemperature.getName() );

		verify( theTemperatureRepository, times( 1 ) ).findOne( "1" );
		verifyNoMoreInteractions( theTemperatureRepository );
	}

	@Test
	public void testGetByIdFail()
	{
		when( theTemperatureRepository.findOne( "1" ) ).thenReturn( Temperature.builder().id( "1" ).name( "Form 3" ).build() );

		Temperature lTemperature = theOrgService.getById( "2" );
		assertNull( lTemperature );

		verify( theTemperatureRepository, times( 1 ) ).findOne( "2" );
		verifyNoMoreInteractions( theTemperatureRepository );
	}

	@Test
	public void testGetByName()
	{
		when( theTemperatureRepository.findByNameIgnoreCase( "Form 3" ) ).thenReturn( Temperature.builder().id( "1" ).name( "Form 3" ).build() );

		Temperature lTemperature = theOrgService.getByName( "Form 3" );
		assertEquals( "1", lTemperature.getId() );
		assertEquals( "Form 3", lTemperature.getName() );

		verify( theTemperatureRepository, times( 1 ) ).findByNameIgnoreCase( "Form 3" );
		verifyNoMoreInteractions( theTemperatureRepository );
	}

	@Test
	public void testGetByNameFail()
	{
		when( theTemperatureRepository.findByNameIgnoreCase( "Form 3" ) ).thenReturn( Temperature.builder().id( "1" ).name( "Form 3" ).build() );

		Temperature lTemperature = theOrgService.getByName( "Form 4" );
		assertNull( lTemperature );

		verify( theTemperatureRepository, times( 1 ) ).findByNameIgnoreCase( "Form 4" );
		verifyNoMoreInteractions( theTemperatureRepository );
	}

	@Test
	public void testSave()
	{
		Temperature lSave = Temperature.builder().id( "1" ).name( "Form 3" ).build();
		when( theTemperatureRepository.save( lSave ) ).thenReturn( lSave );

		Temperature lTemperature = theOrgService.save( lSave );
		assertEquals( "1", lTemperature.getId() );
		assertEquals( "Form 3", lTemperature.getName() );

		verify( theTemperatureRepository, times( 1 ) ).save( lSave );
		verifyNoMoreInteractions( theTemperatureRepository );
	}

	@Test
	public void testDeleteByObject()
	{
		Temperature lDelete = Temperature.builder().id( "1" ).name( "Form 3" ).build();
		theTemperatureRepository.delete( lDelete );

		verify( theTemperatureRepository, times( 1 ) ).delete( lDelete );
		verifyNoMoreInteractions( theTemperatureRepository );
	}

	@Test
	public void testDeleteById()
	{
		theTemperatureRepository.delete( "1" );

		verify( theTemperatureRepository, times( 1 ) ).delete( "1" );
		verifyNoMoreInteractions( theTemperatureRepository );
	}
}
