package test;

/*
 * Copyright 2014 Taylor Caldwell
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import main.java.riotapi.RiotApi;
import dto.Stats.RankedStats;

import org.junit.*;

import constant.Region;
import constant.Season;

public class RankedStatsRequestTest
{
	
	private RiotApi api;

	@Before 
	public void setup()
	{
	   System.out.println("\nTest starting...");
	   api = new RiotApi("YOUR-API-KEY");
	}

	@After 
	public void teardown()
	{
	   System.out.println("\nTest finished.");
	}
	
	@Test 
	public void testGetRankedStatsValidRegionValidIdValidSeason()
	{    
		RankedStats stats = api.getRankedStats(Region.EUW, 32581723, Season.FOUR);
	    Assert.assertNotNull(stats);
	}
	
	@Test 
	public void testGetRankedStatsInvalidRegionValidIdValidSeason()
	{    
		RankedStats stats = api.getRankedStats(Region.TR, 32581723, Season.FOUR);
	    Assert.assertNull(stats);
	}
	
	@Test 
	public void testGetRankedStatsValidRegionInvalidIdValidSeason()
	{    
		RankedStats stats = api.getRankedStats(Region.EUW, 99999999, Season.FOUR);
	    Assert.assertNull(stats);
	}
	
	@Test 
	public void testGetRankedStatsSetValidRegionValidIdValidSeason()
	{   
		api.setRegion(Region.EUW);
		RankedStats stats = api.getRankedStats(32581723, Season.FOUR);
	    Assert.assertNotNull(stats);
	}
	
	@Test 
	public void testGetRankedStatsSetInvalidRegionValidIdValidSeason()
	{    
		api.setRegion(Region.TR);
		RankedStats stats = api.getRankedStats(32581723, Season.FOUR);
	    Assert.assertNull(stats);
	}

	@Test 
	public void testGetRankedStatsValidRegionValidIdSetValidSeason()
	{    
		api.setSeason(Season.FOUR);
		RankedStats stats = api.getRankedStats(Region.EUW, 32581723);
	    Assert.assertNotNull(stats);
	}
	
	@Test 
	public void testGetRankedStatsSetValidRegionValidIdSetValidSeason()
	{    
		api.setSeason(Season.FOUR);
		api.setRegion(Region.EUW);
		RankedStats stats = api.getRankedStats(32581723);
	    Assert.assertNotNull(stats);
	}
	
}



