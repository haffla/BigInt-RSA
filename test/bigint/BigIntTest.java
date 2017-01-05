/**
 *
 * @author Jakob Pupke
 */
package bigint;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jacke
 */
public class BigIntTest {
    
    public BigIntTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of toString method, of class BigInt.
     */
    @Test
    public void testToString() {
        String num = "9021484789375297489789478923565365828490";
        BigInt instance = new BigInt(num);
        
        String result = instance.toString();
        assertEquals(num, result);
        
    }
    
    @Test
    public void testExtendWithZeros() {
        BigInt x = new BigInt(1234);
        x.extendWithZeros(10);
        assertEquals("0000001234", x.toString());
    }
    
    @Test
    public void testKaratsuba() {
        BigInt x = new BigInt(1234);
        BigInt y = new BigInt(4321);
        BigInt c = x.karatsuba(y);
        assertEquals("5332114", c.toString());
        
        x = new BigInt(88888888);
        y = new BigInt(88888888);
        c = x.karatsuba(y);
        assertEquals("7901234409876544", c.toString());
        
        x = new BigInt(88888888);
        y = new BigInt(4444);
        c = x.karatsuba(y);
        assertEquals("395022218272", c.toString());
        
        x = new BigInt("11907858797062763600287");
        y = new BigInt("609258644980293364");
        c = x.karatsuba(y);
        assertEquals("7254965915315125492213065479690094595468", c.toString());
        
        x = new BigInt("275037643193238187969754635193967098168234");
        y = new BigInt("2789096463851958435408110961618870154822");
        c = x.karatsuba(y);
        assertEquals("767106518056437295756217290247277073192355873708821128125451865456623048182324348", c.toString());
        
        x = new BigInt("1161773002875530970475777318025858646972144071496504896369373542143925303581117880759012959257904240775262220379722624450259881493669369582103579798349025470539165815324808002121323272794820292319");
        y = new BigInt("225461820030056738863111393842522918646434913785508706785223950926908750687391732247955346997611273062097910735906920001391888212823475570974758772091099074195005291818882084891523756343366089648730273588212737213447787531009284731961359");
        c = x.karatsuba(y);
        assertEquals("261935455690101553835477616867817994532638410954790388135216273370964797534529434698867203365573514463519154693261215921734833778385249158204506983012447297807770027390554349437402400522684075354375364637327097895729354331681217995385212672256647156206152245528450577573707698166970321064030601231932418788031240573661839756846437852390064206259528820740283846599580492480243484529507512536112300154607427296516019207278922592501521", c.toString());
        
        x = new BigInt("12381284327574325348658436984569459796578485732473274713245743584684564596457645765800807689679896589709876087698768650056759675967965974687945697846848653827347237584368548796579659765979659796579457945979659876598956794569348582875287872873528385834969747965785688583284293492395943694399549");
        y = new BigInt("237574374368436858695796093402992985843688435983285843884369864576834587776216247235843586976457650700958324883584354396945097457004392393219893295093460306450630460430634096934939858285838636457857885387583838468384683486386994597497939495283883483846379759474597865650706435014929358868436845945794597");
        c = x.karatsuba(y);
        assertEquals("2941475878001202787450836365794924592932312176731678332827309067120466107908983335796508746014935869561589884784832594884262627650423161354289059575290678099122590965894330511866154438442233395072712785840660137532550529513399033278658701093486558547404403964828106691758261547875571260572838199921235379290722193802999416226462557194009506350521366528408483562442876164076971655425232719656186535090524667471962118474932664453614901581587019042541150700955706716936891981739391277697439467023493740274142948856471036939203177146104174387075293115770199443171017144582594891874633862217603436753", c.toString());
    }
    
    @Test
    public void testAdd() {
        BigInt x = new BigInt("3553759357973593");
        BigInt y = new BigInt("903590835045676745");
        String expResult = "907144594403650338";
        BigInt c = x.add(y);
        assertEquals(expResult, c.toString());
        
        BigInt d = (new BigInt()).add(new BigInt("123"));
        assertEquals("123", d.toString());
        
        assertEquals("3553759357973594", x.add(new BigInt("1")).toString());
        
        x = new BigInt("1238128432757432534865843698456945979657848573247327471324574358468456459645764576580080768967989658970987608769876865005675967596796597468794569784684865382734723758436854879657965976597965979657945794597965987659895679456934858287528787287352838583496974796578568858328429349239594369439954964578574597569385823873737472742735486875989796598765985999358532737473214723875824383868368544");
        y = new BigInt("237574374368436858695796093402992985843688435983285843884369864576834587776216247235843586976457650700958324883584354396945097457004392393219893295093460306450630460430634096934939858285838636457857885387583838468384683486386994597497939495283883483846379759474597865650706435014929358868436845945794597596834852838423848235884326943963969439694395823852838528852843584386934945748328428731872");
        c = x.add(y);
        
        assertEquals("237575612496869616128330959246691442789668093831859091211841189151193056232675893000420167057226618690617295871193124273810103132971989189817362089663244991316013195154392533789819516251815234423837543333378436434372343382066451532356227024071170836684963256449394444219564763444278598462806285900759176171432422224247721973357069679450845429490994589838837887385581057601658821572712297100416", c.toString());
    }
    
    @Test
    public void testAddNegs() {
        BigInt a = new BigInt("-3553759357973593");
        BigInt b = new BigInt("-903590835045676745");
        String expResult = "-907144594403650338";
        BigInt c = a.add(b);
        assertEquals(expResult, c.toString());
        
        BigInt d = (new BigInt()).add(new BigInt("-1234"));
        assertEquals("-1234", d.toString());
        
        assertEquals("-3553759357973592", a.add(new BigInt("1")).toString());
        
        assertEquals("0", a.add(new BigInt("3553759357973593")).toString());
        
        assertEquals("100", a.add(new BigInt("3553759357973693")).toString());
    }
    
    @Test
    public void testSub() {
        BigInt a = new BigInt(123);
        BigInt b = new BigInt(103);
        String expResult = "20";
        BigInt c = a.sub(b);
        assertEquals(expResult, c.toString());
        
        a = new BigInt();
        b = new BigInt();
        c = a.sub(b);
        assertEquals("0", c.toString());
        
        a = new BigInt(474586);
        b = new BigInt(1289);
        expResult = "473297";
        c = a.sub(b);
        assertEquals(expResult, c.toString());
        
        a = new BigInt(899456);
        b = new BigInt(897988);
        expResult = "1468";
        c = a.sub(b);
        assertEquals(expResult, c.toString());
        
        a = new BigInt(100);
        b = new BigInt(257);
        c = a.sub(b);
        assertEquals("-157", c.toString());
        
        a = new BigInt("-65874");
        b = new BigInt("-9878845");
        c = a.sub(b);
        assertEquals("9812971", c.toString());
        
        a = new BigInt(10000);
        b = new BigInt(49);
        c = a.sub(b);
        assertEquals("9951", c.toString());
    }
    
    @Test
    public void testMul() {
        BigInt a = new BigInt(111);
        BigInt b = new BigInt(5);
        String expResult = "555";
        BigInt c = a.mul(b);
        assertEquals(expResult, c.toString());
        
        a = new BigInt(434043568);
        b = new BigInt(999);
        expResult = "433609524432";
        c = a.mul(b);
        assertEquals(expResult, c.toString());
        
        a = new BigInt();
        b = new BigInt();
        
        assertEquals(a.mul(b).toString(), "0");
        
        assertEquals("0", a.mul(new BigInt("21313435334564566353")).toString());
        
        a = new BigInt(99);
        b = new BigInt(32);
        assertEquals("3168", a.mul(b).toString());
        
        a = new BigInt(123456);
        b = new BigInt(1000000);
        
        assertEquals("123456000000", a.mul(b).toString());
    }

    @Test
    public void testIsEven() {
        BigInt instance = new BigInt();
        assertTrue(instance.isEven());
        
        instance = new BigInt(1);
        assertFalse(instance.isEven());
        
        instance = new BigInt(123154356841L);
        assertFalse(instance.isEven());
        
        instance = new BigInt("-123154356841");
        assertFalse(instance.isEven());
    }

    @Test
    public void testEquals() {
        BigInt a = new BigInt();
        BigInt b = new BigInt();
        assertTrue(a.equals(b));
        
        a = new BigInt(123);
        b = new BigInt(123);
        
        assertTrue(a.equals(b));
        
        b = new BigInt(12315364123L);
        
        assertFalse(a.equals(b));
        
        a = new BigInt(12345);
        b = new BigInt(10);
        assertTrue(a.equals(b.add(new BigInt(12335))));
        assertFalse(a.equals(b.add(new BigInt(12334))));
        
        a = new BigInt("90345723904294274093482048907897782615276532482347588650870");
        b = new BigInt("90345723904294274093482048907897782615276532482347588650870");
        assertTrue(a.equals(b));
        
        a = new BigInt("-90345723904294274093482048907897782615276532482347588650870");
        b = new BigInt("-90345723904294274093482048907897782615276532482347588650870");
        assertTrue(a.equals(b));
        
        a = new BigInt("-90345723904294274093482048907897782615276532482347588650870");
        b = new BigInt("90345723904294274093482048907897782615276532482347588650870");
        assertFalse(a.equals(b));
    }
    
    @Test
    public void testGt() {
        BigInt a = new BigInt();
        BigInt b = new BigInt();
        assertFalse(a.gt(b));
        
        a = new BigInt(567);
        b = new BigInt(566);
        assertTrue(a.gt(b));
        
        a = new BigInt(567);
        b = new BigInt(5668);
        assertFalse(a.gt(b));
        
        a = new BigInt(567);
        b = new BigInt(567);
        assertFalse(a.gt(b));
        
        a = new BigInt("-2344324");
        b = new BigInt(999);
        assertFalse(a.gt(b));
        
        a = new BigInt("-2344334");
        b = new BigInt("-2344324");
        assertFalse(a.gt(b));
        
        a = new BigInt("-2344324");
        b = new BigInt("-2344324");
        assertFalse(a.gt(b));
    }
    
    @Test
    public void testLt() {
        BigInt a = new BigInt();
        BigInt b = new BigInt();
        assertFalse(a.lt(b));
        
        a = new BigInt(567);
        b = new BigInt(566);
        assertFalse(a.lt(b));
        
        a = new BigInt(567);
        b = new BigInt(5668);
        assertTrue(a.lt(b));
        
        a = new BigInt(567);
        b = new BigInt(567);
        assertFalse(a.lt(b));
        
        a = new BigInt(56788);
        b = new BigInt("-56788");
        assertFalse(a.lt(b));
        
        a = new BigInt("-567");
        b = new BigInt();
        assertTrue(a.lt(b));
        
        a = new BigInt(467567);
        b = new BigInt(522432);
        assertTrue(a.lt(b));
        
        a = new BigInt("-467567");
        b = new BigInt("-522432");
        assertFalse(a.lt(b));
    }
    
    
    @Test
    public void testResize() {
        int[] a = new int[5];
        a[0] = 0;
        a[1] = 0;
        a[2] = 1;
        a[3] = 2;
        a[4] = 3;
        BigInt x = new BigInt(a);
        assertEquals("123", x.resize().toString());
    }
    
    @Test
    public void testShiftLeftBy() {
        BigInt a = new BigInt(567);
        BigInt b = a.shiftLeftBy(4);
        assertEquals("5670000", b.toString());
    }
    
    @Test
    public void testPow() {
        BigInt a = new BigInt(8);
        BigInt b = a.pow(23);
        assertEquals("590295810358705651712", b.toString());
        
        a = new BigInt(55);
        b = a.pow(0);
        assertEquals("1", b.toString());
        
        a = new BigInt(587867645);
        b = a.pow(1);
        assertEquals("587867645", b.toString());
        
        a = new BigInt(58786764543534L);
        b = a.pow(1);
        assertEquals("58786764543534", b.toString());
        
        a = new BigInt(52);
        b = a.pow(98);
        assertEquals("1473423784866237624670098483797258933673033687275246807716133162119807965143050991653453567510224775014037060129581571439829382568929663552438113089945991643900772614144", b.toString());
        
        a = new BigInt(38543);
        b = a.pow(4838);
        assertEquals(b.toString(), "63738467015897405821028809393405749510979283822619452432778482464206427033953954634663934744703154001275905302425515561502144115340253356036654726778990917090566620338777917469752161921199425434051488687249151934030549984523076911915802687408907921613418744961082269240566998707027176132447596730537037228313001527495824793726549939267989529426189796722829199126701714079375490000871453474145485842968682915301367733854635926324864409507326121597185019515432823075783137189224539528617906054648707384045373172694493922624446720206970019012791373792309447139305502472790083375110457413201045699392426199786930735130083977636517854166795423441197415199962893404657575999878402310222619014546864770273712156960326755128949650847274470644206736404837613661643541215450040936745237981174342709890132614014443709096105093307712224938517089664377764028868833480692578613392938850484716155780420978599598840350609048254430890185707187391982433695871025549550729052322015310102634000707708034951134213468136138016553393452200210102123456114169906922348444118274597651996184158745839768467029564846343454578378348771826974962541392029581103870405094530609493551747448272067507559700832718585884001971223301330353671691353427233906755127622924718128933051991549619103522188049649663180247431184226329831387836941394257918204536683346731047896356079837990571814703634748256471629336355000931315627585254817706186926094864610337048331487368878596292205245196741917244865448787423991497621120583337516054780059902167573673286471000702870561985859812455081428784533019452291808140339935307788402548602606654573691143450414526853949071028788242270634096243965797465713538712152905288850748811859547295977054795086766192332410307350605528304800820659507173507281297390642167244855725828047160803902033965502675557589547957908867000848775924796859190811519771015615856703008776738950695094091778167778966365399526328202790366346449436502578846186822894054949126920476856805003361723650052506139269286174147242390607437114636011282417546891283875707048760231198941453610111120478810877565694430489307316621406989681158748058890980641852833315607058808287627496667763972476974320045470096406962250181937938379638682581914490246981443093253838926545601181869005239800679515277651438516835281985850455490991963318863556401977912502042162341388348299292097607962471267646993548754249908180925772606027383266354958557736734872040904434367072582295446669516898192945460140583934768364253445446908481576975111710062918400544082592823971842803052122550967235168145991039636308569442636475809135154395286456617137123121498372564837638299160629133098299254987287924943817630042338031258023602555083214420707453243355041758739736299825348508067929795345724756388280504113146143084825778875090405858680585121450208008421082538336342677666012320660226930735260932683740163061618725355596731768592730235156766185460387348963972497354229928165246409240708329245118746534352614779944329645105909254058403583226662575837854563622025098752656994175773078274381322039741209301013647787495972815542513446942655392626267808857307841552567044718669991438568773021157097401296748954873887204653467418747528139796250501827856242920669996638426715629828377257249765613217619759115081471047748625523867395491529775752718164954340584934317114833437611647732913554160545478241246440885954974627907640733529272750849957776125450482477620706673725763609544559263350923813349495281387939774865375713495228511890393736735274047729321437815034909656812337460036387541614014946284633984602130574864577456038330305677661442146852292191239650159790100176673420423940704076186796670428781548894881095378256194608785119268571827874574614126577519455965668786208841101799255632945424682453732242353397514505793255102071732417591276045325795133428183227878345263334111018740190223107285288818106643918983092761729113493572224638480845605632769668910231091448260267564590308952675838886426541174898753293777597342725880863608537744758069040464918458394211747123016911423880687655844206759667094093685440506735768367659279673745251667004215511503109631696443098036070543812337401150473766731931903685669667813893449087065641960765604218762104750266838401122596670862420105237519588961367816462773164786806223046552376024407845036706936467600446047379010073997831641372860787082610685839373928933278878684606266608671088748618662418184576635449144101832920370367785389909936510553533089976599676702867155671559156278694842705692138468507820941395842223457307996830984627446522088385563589831261139537700878984141581955923975365255598521494092894328089011806921882396157599031182211222783861943103231701484235761630566738507217826364010150017688073874840169394349643035989022300037336159854694925094275443737937505743884503503520048652593888030003339871824610887684594542362614002445862152198399748707444832838051556359472615465597642234876699222010405045334682727567723897211879573679229979035277027737460621693204620715413995492746771490981065643574175334071615515427842460457069580478949425973086320632935590120174778279659925768995269825231672944171412113712520266243483424766588167158210056858766208561781474851518723099572978722506060731514191925822639922030674923485884447141753069236377298893952312950932216823363830563881584583784168833916281494805081012795679998092138901572334531267289896567492099013346132611748776202063681425502936500164111862304822898268881046875452902239055210491073107468088830192153197557190610108039353308120129425686165180260671292845133945889374791707999735585714560461681759200960794605795265454895048935081113092266463580666105791919546936118524974966585748139877061069279761076292783540006299731873601995732486128295600740398158992260502093913766269629928584051304142676406580110737127142503853227065006756911230356582684425511966947120694364770695773530834700545493774713178880556154030897149515941258718993542368793602126504848543972683481258526802715519883544732518620645461996942475854539975636446318176696867898122009215816216078756710024298880299337344272279625692740344406385653904706807102904096599051350971134696086582678973819700007966253254619750945900406864920914106902780885555712774049440505866077554152686980375400608096864031331592682932073704504000507336383962318576865970148297169999863614340533069696543093359496280489079250519148719051572709691615041470856878012223558367501092485617610618779021183130419155316507152937623096722637693097722764272740285770871130510926422713234740514867810556744440832437189602237613607563028484040157888394157869454781555451325104441192595552011496865785848009594867891068074250379611465338446796928806271166120082222809928725486393648744208618872839559608284665560512462424536267449675984619077642127198820699009479155155729523495706193396250404117453674273593851387850456224507690625418694431476798603973188490016154024799973186729595775464773744533488897409147637168039758657747406343545543094674316885915990945838230189510902275735441680280533830510756189695072287316673194787984432190978589040978855971985913667072033385195671877196873733486539733358072838302735002017649238850787390021378429488146878703161936763581061308983287419560337055561722533281469651108527794110425950615968542247797201274916869193839920535987656647496636704809698009643389469945658748604647060397939148400770408525288017718460774624172344776667969094606618632035675168169054576454848093680927165261314990241622678531970192877643975875167545730060877945285216884817511422627209853068883062744070804597806858695656071036193483386279546799725514009931158363920374838322674096103283889001930748470899728527834610237600697159673089424881519469263617614342135214272592268283963474266956146598158963041619523732962240522045741091101130637937621347595243932245939939644059801516055373827578421032811411445469662729297663579582871674321708197678333024794551031543541788010354067213751488965707073965532946508420373870423264261832836166147027110706225380055500584221046461008163520245930603084194482749269649063910471137049689746143681477552826360620027836458181138092429553530822721405238031071112662653828048649837953182953790605300804992737061303913651682659926837454411718193824108833353668965512150849137811392220870273581406966793322090242170108647617810082498299667815349017227978094054740092810177112820375226970574386462532503654817899111819728603066842286304119148278840349994919980567656268018301384788608441996692701888333898339843827311417937329912515941057246281361357310691627413705319197933479984178474171710936369264480343095640852702029061324671915490358485035451902912493186089706991732128990202352399071159228771841712235810583988002732884407322930888500414976028291424148394224109086591340252025964531526740042340208516727330201573261467392884417383103814652652667048705033894590939454967213015009869478663472640560405972372220144048543037473673245295221693635784696532986677680836366127447195598482269098601451185467566963056557864638585821888103990327937388206995954128041474755839114748650324913607514701712018576224627231093000685678887423609528296947820258920083476931154889083879169339913321723700718008905862899941165389142084434245392853275653819408963450343958875876219932768224846289389238429618574512922244917744690863033178884626059184914811175552231529659634846574601618595886071636779778160335530891328754323928140407070794898475581983751121205398100249003313748427814656777467639306634923863704358187288480275017355494690969716052108681490068990470325617267786728524776417313698615384787727215379275879430205296514009529922575662442128037860087139248185489567523450681623253194284729952079399942010185587103675420315647411025555126206174252056513236289440762529862645176657289363999010281835570882839667581447103513004745210400035204879218876379163335840108453722294746099429852421705402251244770835946185588260034500721560056320837991896134890830382493180890780589149065157957602481106892798522435070277575899804787102000663878459030880184441168703451211532704725026477019644287843795708967967849897977328444216761122099383962000294963674406999153203508203451773038845742133004201371669535825069135530906647662150491960093892728340054805358142025987119161559195551055524125631394806932786075010330541052541250260986816157550534586964820930952806397452371560436562025319075827811349557931993434601051661342528363861365911526862952916778073898363188119761594527609527314725484558671012910248277975988009389304740834385055681665226138518140815827427039905167513907237268290730962993572712824934773095992720295081565679608547321474976281908333900717188485189148372386654212815493176854357696161595484996258000174524993351133665125269734779584322878555739259253682063530470917608877890320824887872312883030719856520221497832586800807748022114383290145487165492203998200009400378858295457923777383093454401387417494054242624366640710541076467381845841183048310176176181516038361922454573803662951072446548210546063695682113545824619333813875930847848037582026351167688072279572208000867334256242683606139802340786663646729628171874737031150840742054762379711172128061111618721248341471660066084627491248581269173717824834011698621617250771297404810349155878242680581462115697829335739953697530679656285675264565181528891120475766726231702438749583649143689913490522634784797456387713671872903645334212401030325111627833273756853735866527023524856144392406141248038267047743041305871178665749517441515325348031651576269625685524922941188557015058669021289770931452086155352321389630516623262113836053130697491850696155431200805805059931443094771693412903998313845468464750610603076509194869577514916919927469614241379727524434444958570764688001814052508452653493803250686079445679283956518612566085294527797456962155531728728778644696829705407452435804962315134801038818672911002999910776700374854560602870844550143418123507786702843891311971390200910502760895920566000492294589814759662336836369006970091088398737242140521487817573657954326619909230627660453792445745820135150829802742720183141024367959770673313377246266345318759449165348282010653164599800527002113036430540808833837818194253470563648663242694990843928316876686183383933751829666173657147941548500658882406502529802151291911483307800497064812403584561444716950108140837460294096803437260740390388890576118557402786453864018762201563505513658423000492516698985838521442169225474452832565835457337259070198709309482305178885557497022766678397680069171930776745309760966122112607676901289483734859082992582652335953510832916321388778321471102085553466654223886372718541486448345052782724812665600129929027476134027776325431907354669726273185991613964969407533630872082392042645471817577413971418140416413135088072075008345661372473580120481898427939148694243451482556830667123231414496411377463407345570659450549108207964168986268163669616457979750855083911751489227618992585977065470388262325329611979541068992900775469611379127833324026660267907983325872416493006603947632329729978769290839741286417651437936395753822845648771369398885210462668310346338372871087730317619751904615026798481287533865428171634067962995859900734402854082505939399471022379296524489082252739715441738576751699625061210462463248585710112251939608733577963094428446652558036427469408178102080305538937858730794582195499692555508726558149046520364765854484399702481915943574123878638429316969481045549538866528516564353264309374728294906854917954072409020854318251345401476212797027723587443283925087524495099508712124356193472768016090179691485103794391094349115784668845903847132681202445508629067933101207680127831977684300099161449889144283416637712749112894834495331858105054966453426194828345277212593182860979889937993511715813146639842123541587721603394951143248780419338780949656436563256382760021791623435643333299817914372598017079073458665902383415645491386101537646268129363588524066445507785327197404327755816639597799403736796964375809852858727529622539009142280819403897171289544769287115492201612967755920887827207720584556968339500504780285649131143631443270109479534887462061540482794483986825007569649158710107866217297285074795929884416374959801340821892345675013782658371458217688745786471044641104225481258596395704976717149324908950328959723818867031745953719148733161031275266511951222797438455756348008215517069761571336129822693026582580687397771115665767522501275029335505080353941233718350081547850373204623863163560112914173446466111498232344480664761690973257306735284261161732720865811191168457071402252739217727397255583132155234514337915791489240285676450817982417661767934561965877469943215118244133992820327786472950527664280475127151645623231204135703400744977136596095610346033671345773583181568616175374874886144796488229337186466169503037212123694928019998897512926585756523684342203103618041614585808294122405968466587908327212859263695733429962741863576351253170501709729915760546203689837260672066550825486666600608939752814674801128070848474775573493323709085194486520867452615002570898997736976209911583916404578370506876249712184712503594033922838350093562147430338140917618129951011749239576690181715246687295018438198606596687388271416614264669535145302302852183915684317936783648662673928643590206970588397804691712124987755749061214306439554207051292768991020381838147402570810723093660252799387423111017817572815987000719085275639296081653146064510783025820955945404162016700786176511123492882396700829064424397879090345521884359395979869446159900438483366150771226861933838670529498901993466185589147577837750077786625886376822459368631523542495564839097528669684086669402050901006439825689163694716761824264509579622219269086711508521141029638174831892498425238809935725952663548024836098604707111212322032192279980909142155425665674829277666974099512430739851021846401743437551805621470481130855676275936474657302552826670604555815204824774645392421932324152930909449270641964169526472731151699935682597627015250832714857824514119877600512976723374315477660342227332946050499289627492837267888313986714081900692808835383731505348749190007536369583605777546078970370422420107723108250667812842160936131318841813083521910224847137525827952521702378670287581778531001068189991299156881575564032119392149520436231344334006822472191385609995361615199114725490811610713688249053445957113364346174483992520721188960451878931765887518236618473363169035524662636263300172653835922454247452073724666104754443743394060102198575440054960788378747579823550511957498837393926945999214111295236253096074049539573968679476880567606657716154654071411092894104072041149303686874574166786856442050126599311667854640357391066732544668686105904974459279351124682568104826802054357720440922176673129525304341159284003476307313552799892756225902404781993377186837161928634309703864329917909203394449643239089663715723803782089737439831121913802179155735775943186619276059160017419547732875474116018678800304373913360339000885972021635984240547168666052667940041769472719393904974253720309695146284469757277488962758990514633205077625703150173598644492593550389202739069576150871081017290992959270778706383888735712096559153801490389963487456696330901368567836508672037581074874975866532102398023863896183076169214926792274858438970351134422365531766446616714266248658773708992443755952791953309721616172929784822451684775878991238614787404851123293191425034605773541818717744555883475453618835099882013411892914639962811887361232386896661054243155661905471456269958942172409591324765449510515084441911190297717509988442822000553612689515460328711549662962427997941866051268777196659471653894083351947905167024712086361610494658046050780455997008133177161514800714821462142907486463884470707099473201177263986168066359882106791395069074848483424126785529854994059800986597912154118876761716637706400884750187703216655745496654150860027260916247287185608085798853453591057347439188012760803316175773866708230515858523143320195515958249533412759914373084879981791370554193499333420823726413560741508202106202107461016865455302968661960384987854907902484131138504881572635812757529706392120598688495401115442951218765677479714408182511873258428727789693701172684941889988600058934740230536952710313498025334235326047321841601161134962757222981995780871090909385412525837822399140029939908889130030857756724909368252708014750793051658088882266561456677785712021422026371040843650219735419926850861296261159345677016736858983126618932024787493038239519704723820691079991103835796555333035517840767330095018824722409967733814683022333213288737666012051262142385270846965986363977172916499030457977657821127434742724716752345143741571186484378933778473860879731799335756854819646338752505604040724185458249050013476759113262641403080015441563577821831334338874661710176712956483217584659996978788799584055296025566696876169198829122920523404530547113901687585342177676999744090060027230737936277529100178590831698934614275607276544277734931214822751126813864436621783128672404639536506429378449605102980163304369651749709565625590412965001090926286535846294944281297914042421771418175698087843454875890463117488572026867476265617246445079056680881127713487518743168706749045114195090891054977761341937213430036747976635907991519815112267241261663059248373478870131918954558423762867132663591221036667552676848121169101749004689650753635885432495939251635622811773489103125205722564912941610995545411142978046227536774620201336991763956863843498945404390205775983917711155856304290938661429085909505744830892873623030678011191525263960272246301973877044778824905112866798851092334503857484866778021256837916524907429376368371072793095689521421700426886182945485881286633959377276254927692868292845105662689041798440511963105702431176590038889037262403096559865037332425285477314921894529289437797086890734940600647659944093163643127784083023345680636739088931737419897221386474039896449525702351172730883773423662211456482937025313115472733408684890445835995002543936135441649443315974382054247042385447304336345419287720638793447774868195285007926138791407961120354547210611563463212305015198891832178740040606334419695313536019225296379358323114057381783740720876799633115055097753540984219586808616728778073128601757047792526238819367318045263976280900322383336704739060025453855661649996585005846741502916877057367126590511734307773212374783091157847786730373241842382690722970710688460131702444241470419451894819796432666262484132925071371282047158456934543493558723620115461603575945475871461851507064200911861162494185107042419366794297142336854661203625573670950668434246696460753229025078951029929847767472132871736893734151078769881739319878519617252506533476269968607502794848925629797826782782176970757348768967498728919593957924253789999816203854225905491755087033073304009678000206958751814098089826554096728194752275052698042008015415481815629954843665729595481788023887267891410191596428425518877559136372733136242539324935508906951271299221274742618109936854046168051084323427095561956982482911525530844967685987124667723263805497618620638791486601295710124953493463149822905475974202969879627499441272140354341395082910789801081151017348300647914448448368397100310033545799353555121874807613627088788235754053072303933402495716783128245420583102325085427543105524445387687915515249179900696071827322768758871770848299372136578464860332769326384429298272969650491765286571903433200938226740218150463738063678535605231594280754933272067515953836872047336110390699768775817380393906363707134748018799659875635288429698297434414281472796349443111006839199564133952401097182684382988929107545071794599823366148933480319944614279012216270413836792366127410918751530892462385418443901253389508320253793892417907761337803712222915631682696956078140119806452700652094235738944957860377708863286857553423631475754157481668115056501363342933012916385599246587660326641756787230781140257506590994658661881949759161051338531337023010371644418786583943575484988252761362048395784608436464275525846938044085679062044602104798590698143751160849285851458347958030793546566899602081690259479211506132707444153164560464908333831416769102505147455645756258221460970790400243694463278143711649");
    }
    
    @Test
    public void testMod() {
        BigInt a = new BigInt(9);
        BigInt b = new BigInt(2);
        assertEquals("1", a.mod(b).toString());
        
        a = new BigInt(658448);
        b = new BigInt(178);
        assertEquals("26", a.mod(b).toString());
        
        a = new BigInt("237574374368436858695796093402992985843688435983285843884369864576834587776216247235843586976457650700958324883584354396945097457004392393219893295093460306450630460430634096934939858285838636457857885387583838468384683486386994597497939495283883483846379759474597865650706435014929358868436845945794597596834852838423848235884326943963969439694395823852838528852843584386934945748328428731872");
        b = new BigInt("1238128432757432534865843698456945979657848573247327471324574358468456459645764576580080768967989658970987608769876865005675967596796597468794569784684865382734723758436854879657965976597965979657945794597965987659895679456934858287528787287352838583496974796578568858328429349239594369439954964578574597569385823873737472742735486875989796598765985999358532737473214723875824383868368544");
        assertEquals("1052562507946473203138699375734320960793900015401359139212099548693842927294517081108946110826947946251525211611662790987118563464474310122450238343651946108930938011945771289688730244326315111588374331526790216240616510877054428628261799333463606396738532305494545789083053486751665928847387493125240623531567707228228535498986712171278526579664309923908653745669954917887147282004140608", a.div(b).rest.toString());
        
        a = new BigInt("8435238458243858");
        b = new BigInt("-10");
        assertEquals("-843523845824385", a.div(b).quotient.toString());
    }
    
    @Test
    public void testPowMod() {
        BigInt a = new BigInt(2);
        int e = 588;
        BigInt m = new BigInt(57687);
        assertEquals("25348", a.powMod(e, m).toString());
        
        a = new BigInt(38848);
        e = 49838;
        m = new BigInt(8456765);
        assertEquals("4018389", a.powMod(e, m).toString());
    }
    
    @Test
    public void testDiv() {
        BigInt a = new BigInt(28382);
        BigInt b = new BigInt(23);
        BigInt c = a.div(b).quotient;
        assertEquals("1234", c.toString());
        
        a = new BigInt(5675745);
        b = new BigInt(1000);
        c = a.div(b).quotient;
        assertEquals(c.toString(), "5675");
        
        a = new BigInt("1238128432757432534865843698456945979657848573247327471324574358468456459645764576580080768967989658970987608769876865005675967596796597468794569784684865382734723758436854879657965976597965979657945794597965987659895679456934858287528787287352838583496974796578568858328429349239594369439954964578574597569385823873737472742735486875989796598765985999358532737473214723875824383868368544");
        b = new BigInt("237574374368436858695796093402992985843688435983285843884369864576834587776216247235843586976457650700958324883584354396945097457004392393219893295093460306450630460430634096934939858285838636457857885387583838468384683486386994597497939495283883483846379759474597865650706435014929358868436845945794597596834852838423848235884326943963969439694395823852838528852843584386934945748328428731872");
        c = a.div(b).quotient;
        assertTrue(c.isZero());
        
        a = new BigInt("237574374368436858695796093402992985843688435983285843884369864576834587776216247235843586976457650700958324883584354396945097457004392393219893295093460306450630460430634096934939858285838636457857885387583838468384683486386994597497939495283883483846379759474597865650706435014929358868436845945794597596834852838423848235884326943963969439694395823852838528852843584386934945748328428731872");
        b = new BigInt("1238128432757432534865843698456945979657848573247327471324574358468456459645764576580080768967989658970987608769876865005675967596796597468794569784684865382734723758436854879657965976597965979657945794597965987659895679456934858287528787287352838583496974796578568858328429349239594369439954964578574597569385823873737472742735486875989796598765985999358532737473214723875824383868368544");
        c = a.div(b).quotient;
        
        assertEquals("191881", c.toString());
    }
    
}
