#Hönnunarskýrsla

Í upphaflegum drögum að hönnun leiksins voru tveir klasar skilgreindir, ```Move``` og ```TicTacToeGame```.

Í ```Move``` klasanum eru skilgreindar stöður á ```TicTacToe``` leikborðinu. Klasinn hefur eigindin ```position``` og ```player```. ```Position``` er ```int``` og má taka gildi á bilinu ```0-8```. Það segir til um á hvaða reit þetta 
```move``` átti sér stað. ```Player``` er ```char``` breyta og má hafa gildið ```X``` eða ```O``` og segir til um hvaða leikmaður framkvæmdi aðgerðina. 

```TicTacToeGame``` klasinn er gagnatýpa sem geymir allar upplýsingar um ákveðinn mylluleik. Klasinn hefur bæði 
færibreytulausan smið og færibreytusmið, þar sem sá fyrri býr til nýjan leik og lætur leikmann ```X``` byrja 
en færibreytusmiðurinn tekur við ```char``` breytu sem þarf annað hvort að hafa gildið ```X``` eða ```O``` og býr til 
nýtt tilvik af ```TicTacToeGame``` með þann upphafsleikmann.

Fallið ```hasmove``` skilar þeim leikmanni sem á leik hverju sinni. Klasinn inniheldur tvö mismunandi ```Move``` föll. 
```Move move(int position)```, tekur inn staðsetningu á leikborðinu og fær upplýsingar frá ```hasMove``` fallinu um hvaða 
leikmaður eigi leik til að framkvæma aðgerðina . ```Move move(int position, char player)``` tekur inn bæði 
staðsetninguna á leikborðinu og leikmanninn sem á að framkvæma aðgerðina. Bæði þessi föll skila ```null``` ef ekki 
var hægt að framkvæma það move sem búið var til í föllunum. Fallið ```getBoard``` skilar lista af öllum ```move``` sem 
hafa átt sér stað í leiknum.

Fallið ```gameOver``` er fall sem gengur úr skugga um að leiknum sé lokið samkvæmt reglunum. Það býr til ```char``` fylkið 
```gameboard``` af stærð 9 sem táknar borðið í leiknum.

```endGame``` fallið er hjálparsfall fyrir ```gameOver``` fallið. það tekur inn ```char``` breytu og gefur eigindunum ```winner``` það gildi og eigindunum ```gameIsOver``` gildið true. 

```resetGame``` hefur nýjan leik með ```X``` sem upphafsleikmann.
