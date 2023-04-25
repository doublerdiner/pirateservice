package com.codeclan.pirateservice.components;

import com.codeclan.pirateservice.models.Pirate;
import com.codeclan.pirateservice.models.Raid;
import com.codeclan.pirateservice.models.Ship;
import com.codeclan.pirateservice.repositories.PirateRepository;
import com.codeclan.pirateservice.repositories.RaidRepository;
import com.codeclan.pirateservice.repositories.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    private PirateRepository pirateRepository;
    @Autowired
    private ShipRepository shipRepository;
    @Autowired
    private RaidRepository raidRepository;
    public DataLoader(){}
    @Override
    public void run(ApplicationArguments args){
        Ship dutchman = new Ship("The Flying Dutchman");
        shipRepository.save(dutchman);

        Ship pearl = new Ship("The Black Pearl");
        shipRepository.save(pearl);

        Ship blackPig = new Ship("The Black Pig");
        shipRepository.save(blackPig);

        Ship dustman = new Ship("The Flying Dustman");
        shipRepository.save(dustman);

        Ship galley = new Ship("Adventure Galley");
        shipRepository.save(galley);

        Ship revenge = new Ship("Queen Anne's Revenge");
        shipRepository.save(revenge);

        Ship fancy = new Ship("Fancy");
        shipRepository.save(fancy);

        Ship fortune = new Ship("Royal Fortune");
        shipRepository.save(fortune);

        Pirate jack = new Pirate("Jack", "Sparrow", 32, pearl);
        pirateRepository.save(jack);

        Pirate john = new Pirate("John", "Silver", 55, dutchman);
        pirateRepository.save(john);

        Pirate pugwash = new Pirate("Horatio", "Pugwash", 55, blackPig);
        pirateRepository.save(pugwash);

        Pirate maggie = new Pirate("Maggie", "Lafayette", 35, dustman);
        pirateRepository.save(maggie);

        Pirate william = new Pirate("William", "Kidd", 40, galley);
        pirateRepository.save(william);

        Pirate blackbeard = new Pirate("Edward", "Teach", 45, revenge);
        pirateRepository.save(blackbeard);

        Pirate henry = new Pirate("Henry", "Avery", 25, fancy);
        pirateRepository.save(henry);

        Pirate bart = new Pirate("Bartholomew", "Roberts", 47, fortune);
        pirateRepository.save(bart);


        Raid raid1 = new Raid("Tortuga", 100);
        raidRepository.save(raid1);

        Raid raid2 = new Raid("Treasure Island", 690);
        raidRepository.save(raid2);

        Raid raid3 = new Raid("Barbados", 500);
        raidRepository.save(raid3);

        Raid raid4 = new Raid("St. Kitts", 500);
        raidRepository.save(raid4);

        Raid raid5 = new Raid("Havana", 200);
        raidRepository.save(raid5);

        Raid raid6 = new Raid("Port Royal", 1000);
        raidRepository.save(raid6);

        jack.addRaidToPirate(raid1);
        jack.addRaidToPirate(raid2);
        pirateRepository.save(jack);

        raid2.addPirateToRaid(john);
        raidRepository.save(raid2);

        raid3.addPirateToRaid(pugwash);
        raid3.addPirateToRaid(maggie);
        raidRepository.save(raid3);

        raid4.addPirateToRaid(pugwash);
        raid3.addPirateToRaid(jack);
        raidRepository.save(raid4);

        blackbeard.addRaidToPirate(raid5);
        blackbeard.addRaidToPirate(raid6);
        pirateRepository.save(blackbeard);

        raid5.addPirateToRaid(william);
        raidRepository.save(raid5);

        raid6.addPirateToRaid(henry);
        raidRepository.save(raid6);
    }
}
