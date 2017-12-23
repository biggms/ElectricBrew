package com.gmail.gstewart05;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmail.gstewart05.deviceservice.temperature.model.Temperature;
import com.gmail.gstewart05.deviceservice.temperature.service.TemperatureService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith( SpringRunner.class )
@SpringBootTest
public class TemperatureControllerTests
{
	private MockMvc theMvc;

	@Mock
	private TemperatureService theTemperatureService;

	@InjectMocks
	private TemperatureController theTemperatureController;

	@Autowired
	private WebApplicationContext theWebApplicationContext;

	public static String asJsonString( final Object obj )
	{
		try
		{
			return new ObjectMapper().writeValueAsString( obj );
		}
		catch( Exception e )
		{
			throw new RuntimeException( e );
		}
	}

	@Before
	public void setup()
	{
		theMvc = MockMvcBuilders.standaloneSetup( theTemperatureController ).build();
	}

	@Test
	public void testGetAll() throws Exception
	{
		List< Temperature > lList = new ArrayList<>();
		lList.add( Temperature.builder().name( "Form 3" ).build() );
		lList.add( Temperature.builder().name( "Apple" ).build() );
		lList.add( Temperature.builder().name( "Samsung" ).build() );
		when( theTemperatureService.getAll() ).thenReturn( lList );

		theMvc.perform( MockMvcRequestBuilders.get( "/org/v1" ).accept( MediaType.APPLICATION_JSON ) )
				.andExpect( jsonPath( "$", hasSize( 3 ) ) );

		verify( theTemperatureService, times( 1 ) ).getAll();
		verifyNoMoreInteractions( theTemperatureService );
	}

	@Test
	public void testGetById() throws Exception
	{
		when( theTemperatureService.getById( "1" ) ).thenReturn( Temperature.builder().id( "1" ).name( "Form 3" ).build() );

		theMvc.perform( MockMvcRequestBuilders.get( "/org/v1/1" ).accept( MediaType.APPLICATION_JSON ) )
				.andExpect( status().isOk() )
				.andExpect( jsonPath( "$.id", is( "1" ) ) )
				.andExpect( jsonPath( "$.name", is( "Form 3" ) ) );

		verify( theTemperatureService, times( 1 ) ).getById( "1" );
		verifyNoMoreInteractions( theTemperatureService );
	}

	@Test
	public void testGetByIdFail() throws Exception
	{
		when( theTemperatureService.getById( "2" ) ).thenReturn( null );

		theMvc.perform( MockMvcRequestBuilders.get( "/org/v1/2" ).accept( MediaType.APPLICATION_JSON ) )
				.andExpect( status().isNotFound() );

		verify( theTemperatureService, times( 1 ) ).getById( "2" );
		verifyNoMoreInteractions( theTemperatureService );
	}

	@Test
	public void testGetByName() throws Exception
	{
		when( theTemperatureService.getByName( "Form 3" ) ).thenReturn( Temperature.builder().id( "1" ).name( "Form 3" ).build() );

		theMvc.perform( MockMvcRequestBuilders.get( "/org/v1/search/Form 3" ).accept( MediaType.APPLICATION_JSON ) )
				.andExpect( status().isOk() )
				.andExpect( jsonPath( "$.id", is( "1" ) ) )
				.andExpect( jsonPath( "$.name", is( "Form 3" ) ) );

		verify( theTemperatureService, times( 1 ) ).getByName( "Form 3" );
		verifyNoMoreInteractions( theTemperatureService );
	}

	@Test
	public void testGetByNameFail() throws Exception
	{
		when( theTemperatureService.getByName( "Form 4" ) ).thenReturn( null );

		theMvc.perform( MockMvcRequestBuilders.get( "/org/v1/search/Form 4" ).accept( MediaType.APPLICATION_JSON ) )
				.andExpect( status().isNotFound() );

		verify( theTemperatureService, times( 1 ) ).getByName( "Form 4" );
		verifyNoMoreInteractions( theTemperatureService );
	}

	@Test
	public void testCreate() throws Exception
	{
		Temperature lTemperature = Temperature.builder().id( "1" ).name( "Form 3" ).build();
		when( theTemperatureService.save( lTemperature ) ).thenReturn( lTemperature );

		theMvc.perform( MockMvcRequestBuilders.post( "/org/v1" ).contentType( MediaType.APPLICATION_JSON ).content( asJsonString( lTemperature ) )
				.accept( MediaType.APPLICATION_JSON ) )
				.andExpect( status().isOk() )
				.andExpect( jsonPath( "$.name", is( "Form 3" ) ) );

		verify( theTemperatureService, times( 1 ) ).save( any( Temperature.class ) );
		verifyNoMoreInteractions( theTemperatureService );
	}

	@Test
	public void testUpdate() throws Exception
	{
		Temperature lTemperature = Temperature.builder().id( "1" ).name( "Form 4" ).build();
		when( theTemperatureService.getById( "1" ) ).thenReturn( Temperature.builder().id( "1" ).name( "Form 3" ).build() );
		when( theTemperatureService.save( lTemperature ) ).thenReturn( lTemperature );

		theMvc.perform( MockMvcRequestBuilders.put( "/org/v1/1" ).contentType( MediaType.APPLICATION_JSON ).content( asJsonString( lTemperature ) )
				.accept( MediaType.APPLICATION_JSON ) )
				.andExpect( status().isOk() )
				.andExpect( jsonPath( "$.name", is( "Form 4" ) ) );

		verify( theTemperatureService, times( 1 ) ).getById( "1" );
		verify( theTemperatureService, times( 1 ) ).save( any( Temperature.class ) );
		verifyNoMoreInteractions( theTemperatureService );
	}

	@Test
	public void testUpdateFail() throws Exception
	{
		Temperature lTemperature = Temperature.builder().id( "1" ).name( "Form 4" ).build();
		when( theTemperatureService.save( lTemperature ) ).thenReturn( lTemperature );

		theMvc.perform( MockMvcRequestBuilders.put( "/org/v1/2" ).contentType( MediaType.APPLICATION_JSON ).content( asJsonString( lTemperature ) )
				.accept( MediaType.APPLICATION_JSON ) )
				.andExpect( status().isNotFound() );

		verify( theTemperatureService, times( 1 ) ).getById( "2" );
		verifyNoMoreInteractions( theTemperatureService );
	}

	@Test
	public void testDelete() throws Exception
	{
		Temperature lTemperature = Temperature.builder().id( "1" ).name( "Form 3" ).build();
		when( theTemperatureService.getById( "1" ) ).thenReturn( Temperature.builder().id( "1" ).name( "Form 3" ).build() );
		doNothing().when( theTemperatureService ).delete( lTemperature );

		theMvc.perform( MockMvcRequestBuilders.delete( "/org/v1/1" )
				.accept( MediaType.APPLICATION_JSON ) )
				.andExpect( status().isOk() );

		verify( theTemperatureService, times( 1 ) ).getById( "1" );
		verify( theTemperatureService, times( 1 ) ).delete( any( Temperature.class ) );
		verifyNoMoreInteractions( theTemperatureService );
	}

	@Test
	public void testDeleteFail() throws Exception
	{
		when( theTemperatureService.getById( "2" ) ).thenReturn( null );
		doNothing().when( theTemperatureService ).delete( any( Temperature.class ) );

		theMvc.perform( MockMvcRequestBuilders.delete( "/org/v1/2" )
				.accept( MediaType.APPLICATION_JSON ) )
				.andExpect( status().isNotFound() );

		verify( theTemperatureService, times( 1 ) ).getById( "2" );
		verifyNoMoreInteractions( theTemperatureService );
	}
}
