package com.google.code.wiifitparser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import org.codehaus.preon.Codec;
import org.codehaus.preon.Codecs;
import org.codehaus.preon.DecodingException;

import au.com.bytecode.opencsv.CSVWriter;

public class FileReader {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Strating FileReader.main()");

		if (args == null || args.length == 0 || args.length > 2) {
			System.err.println("Wrong arguments!"+"\n"+
					"First Argument = Path to decrypted WiiFitSavegame File"+"\n"+
					"For decryption see git.infradead.org/users/segher/wii.git"+"\n"+
					"Optional second parameter = path to target csv file."+"\n"+
					"If ommited I will use current directory and filename output.csv"
					);
		} else {
			Codec<WiiFitSaveGame> codec = Codecs.create(WiiFitSaveGame.class);
			try {
				File file = new File(args[0]);
				WiiFitSaveGame saveGame = Codecs.decode(codec, file);
				
				System.out.println("Finished decoding Savegame File, starting to write csv file");

				String outputfilePath = "output.csv";
				if(args.length == 2)
					outputfilePath = args[1];
				
				CSVWriter writer = new CSVWriter(
						new FileWriter(outputfilePath));

				String[] csvHeader = new String[] { "Mii-ID", "Mii-Name",
						"Birthday", "HeightInCm", "BodyTestDate", "BMI", "kg", "balanceRight",
						"WiiFitAge", "BodyTestCounter" };
				writer.writeNext(csvHeader);

				for (Player player : saveGame.players) {
					// String[] playerValues = new String[] {
					// player.getPlayerID(), player.mii_name,
					// player.getBirthday().toString(),
					// Integer.toString(player.heightInCm) };
					
					if(player.getBirthday() == null)
						break;

					int counter = 1;
					for (BodyTest bodyTest : player.bodyTests) {
						
						if(bodyTest.year == 0 && bodyTest.monthMinus1 == 0 && bodyTest.day == 0)
							break;
						
						String[] values = new String[] { player.getPlayerID(),
								player.mii_name,
								MyTools.formatDateWithoutTime(player.getBirthday()),
								Integer.toString(player.heightInCm),
								MyTools.formatDateWithTime(bodyTest.getDate()),
								Float.toString(bodyTest.getBmi()),
								Float.toString(bodyTest.getKg()),
								Float.toString(bodyTest.getBalanceRight()),
								Integer.toString(bodyTest.wiiFitAge),
								Integer.toString(counter) };
						writer.writeNext(values);
						counter += 1;
					}
				}

				writer.close();

				// System.out.println("read bodyTest: " + player.toString());
				// System.out.println("read bodyTest for mii_name=" +
				// player.mii_name);
				// System.out.println("birthdate =" +
				// player.getBirthday().toString());
				// System.out.println("bodytestdate =" +
				// player.getDate().toString());
				// System.out.println("wiiFitAge =" + player.wiiFitAge);

//				System.out.println("last out for this player");

				// Integer.toHexString(player.birthYear)

				// System.out.println(player.getPlayerID())
				// Integer.toHexString(bodyTest.birth1)
				// BaseConverter.toBase16(-111)

			} catch (FileNotFoundException e) {
				System.err.println("could not find File");
			} catch (DecodingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// BodyTest bodyTest = Codecs.decode(codec, buffer);

		System.out.println("Finished FileReader.main()");
	}

}
