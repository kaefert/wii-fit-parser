# wii-fit-parser
Automatically exported from code.google.com/p/wii-fit-parser

## History of this project

In 2012 I had accumulated over 1000 "body tests" with the Wii "game?" "Wii fit". I wanted to back up the data in a format that can be worked with.

In my research how to do that, I found the existing python script "wiifit" https://code.google.com/archive/p/wiifit/ and it looked like it worked fine at first, but then I found out it gave wrong values for about 30 of my 1100 bodytests in the columns bmi & weight in kg. Instead of trying to hunt down the bug in the what was in my opinion not very easily readable python code, I created this project.

Below the original HowTo I published in 2012 on google code (where this project was originally hosted), original can be found still at:
https://code.google.com/archive/p/wii-fit-parser/wikis/HowTo.wiki

## Retrieve your Savegame

First you need to retrieve your Wii-Fit Savegame from your Wii. You can use the Wii Savegame manager to export it to an SD-Card. If you exported lots of savegames at once, and don't know how to find your Wii-Fit savegame, the Gamecode which is used as Foldername is either RFPP (for the PAL-Version) or RFPE (for the NTSC-Version).

## Decrypting your Savegame

Everything that the Wii saves to the SD-Card is encrypted (except some homebrew software). To Parse the Savegame, it first needs to be decrypted.
Look at those links for a deeper understanding:

http://hackmii.com/2008/04/keys-keys-keys/

http://git.infradead.org/?p=users/segher/wii.git


Another Guide that describes this step quite well (for Ubuntu users at least) is found here:

http://jansenprice.com/blog?id=9-Extracting-Data-from-Wii-Fit-Plus-Savegame-Files

For you to have it a little bit easier to use the segher's wii tool I provide the **required sd-keys** here:

https://github.com/kaefert/wii-fit-parser/releases/download/v1.0/wii-sd-keys.zip

You need to extract this .wii directory into your homefolder


**A short summary for Ubuntu users:**
```
sudo apt-get install git-core
sudo apt-get install openssl libssl-dev
cd /to/some/path/where/you/want/to/store/the/tool
git clone git://git.infradead.org/users/segher/wii.git
cd wii
make
./tachtig /path/to/savegame/data.bin
```

## Parsing the decrypted Savegame

This is the part where this project here comes into play. Just download the all-in-one jar from here:

https://github.com/kaefert/wii-fit-parser/releases/download/v1.0/wiifitparser.jar

and run it on the console like this:

```
java -jar path/to/jar/wiifitparser.jar "/path/to/decrypted/savegame/FitPlus0.dat" "/path/where/you/want/the/csv/file.csv"
```

## More than data extraction

Because I didn't script the data extraction as some procedural little program, but instead used this binary data handling tool: https://github.com/wspringer/preon to just describe the Wii-Fit-Savegame format with annotations and therefore create a mapping between its binary format and an object-tree, it should be quite doable to extend this project to also go the other direction --> modify the objects and write them back into a binary file, so for example move bodytests between players, like for example the user gffall asked for as a comment to this blog-entry which I already linked above:

http://jansenprice.com/blog?id=9-Extracting-Data-from-Wii-Fit-Plus-Savegame-Files

## Links concerning Wii Fit Savegames

  * A project that does the same (but with much more details like number of times you played some games and highscores and stuff like that) as this, but implemented as a python script, and having some strange error that gives me values like 5kg or an bmi of 0.5% for about 30 of my 1100 bodytests. http://code.google.com/p/wiifit/
  * A blog entry about the wii fit data extraction: http://jansenprice.com/blog?id=9-Extracting-Data-from-Wii-Fit-Plus-Savegame-Files
  * A stackoverflow discussion: http://stackoverflow.com/questions/616249/wii-fit-data-format
  * A blogentry of a guy that wants 5$ for using the python script mentioned above on his webserver. Warning: could collect your submitted data: http://www.huanix.com/2010/04/03/export-wii-fit-data-to-a-csv-for-import-into-excel-or-database/ UPDATE: not online anymore on 2012-07-22

## About Preon

This project uses Preon to map the binary file to java object instances.

Here are some links for information on Preon:

  * http://preon.codehaus.org/
  * https://github.com/wspringer/preon
  * http://www.scribd.com/springerw/d/8128172-Preon-Introduction
  * http://www.scribd.com/springerw/d/7988375-Preon-Under-the-Hood
