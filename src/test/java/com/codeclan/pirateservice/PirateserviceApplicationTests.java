package com.codeclan.pirateservice;

import com.codeclan.pirateservice.models.Pirate;
import com.codeclan.pirateservice.models.Raid;
import com.codeclan.pirateservice.models.Ship;
import com.codeclan.pirateservice.repositories.PirateRepository;
import com.codeclan.pirateservice.repositories.RaidRepository;
import com.codeclan.pirateservice.repositories.ShipRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PirateserviceApplicationTests {
	@Autowired
	PirateRepository pirateRepository;
	@Autowired
	ShipRepository shipRepository;
	@Autowired
	RaidRepository raidRepository;

	@Test
	void contextLoads() {
	}
	@Test
	public void canCreatePirate(){
		Ship ship = new Ship("ShipOne");
		shipRepository.save(ship);
		Pirate pirate = new Pirate("Jack", "Sparrow", 40, ship);
		pirateRepository.save(pirate);
	}

	@Test
	public void canAddPiratesToRaids(){
		Ship ship = new Ship("The Unicorn");
		shipRepository.save(ship);
		Pirate pirate = new Pirate("John", "Silver", 35, ship);
		Pirate pirate1 = new Pirate("Black", "Beard", 20, ship);
		pirateRepository.save(pirate);
		pirateRepository.save(pirate1);
		Raid raid = new Raid("Dundee", 500);
		raid.addPirateToRaid(pirate);
		raid.addPirateToRaid(pirate1);
		raidRepository.save(raid);

	}
	@Test
	public void canAddRaidsToPirates(){
		Ship ship = new Ship("The Unicorn");
		shipRepository.save(ship);
		Raid raid = new Raid("Edinburgh", 500);
		Raid raid2 = new Raid("Aberdeen", 50);
		raidRepository.save(raid);
		raidRepository.save(raid2);
		Pirate pirate = new Pirate("John", "Silver", 35, ship);
		pirate.addRaidToPirate(raid);
		pirate.addRaidToPirate(raid2);
		pirateRepository.save(pirate);
	}

}
