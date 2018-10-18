var path = 'http://localhost:8080/uta-macross'

var strLogin = path+'/view/login';
var strToMain = path+'/view/toMain';
var strToSinger = path+'/view/singer';
var strToOpus = path+'/view/opus';
var strToAttribute  = path+'/view/attribute';
var strToDifficult = path+'/view/difficult';
var strToAddSong = path+'/view/addSong';
var strToEditSong = path+'/view/editSong';
var strToFighter = path+'/view/fighter';
var strToClothing = path+'/view/clothing';
var strToAddCard = path+'/view/addCard';
var strToSkill = path+'/view/skill';


//添加歌姬
var strAddSinger = path+'/singer/addSinger';
//获取所有歌歌姬
var strQueryAllSinger = path+'/singer/queryAllSinger';
//添加难度
var strAddDiff = path+'/diff/addDiff';
//获取所有歌难度
var strQueryAllDiff = path+'/diff/queryAllDiff';
//添加作品
var strAddOpus = path+'/opus/addOpus';
//获取所有歌作品
var strQueryAllOpus = path+'/opus/queryAllOpus';
//添加属性
var strAddAttr = path+'/attr/addAttr';
//获取所有属性
var strQueryAllAttr = path+'/attr/queryAllAttr';
//通过歌姬获取对应的作品
var strGetOpusBySingerID = path+'/singer/getOpusBySingerID'

//添加歌曲
var strAddSong = path+'/song/addSong';
//添加歌曲属性作品
var strAddSongOpusAttr = path+'/song/addSongOpusAttr';
//添加歌曲难度信息
var strAddSongDiff = path+'/song/addSongDiff';
//添加歌姬熟练度信息
var strAddSongSinger = path+'/song/addSongSinger';

//添加飞机
var strAddFighter = path+'/fighter/addFighter';
//获取所有飞机
var strQueryAllFighter = path+'/fighter/queryAllFighter';
//获取飞机对应的作品
var strQueryFighterOpus = path+'/fighter/queryFighterOpus';

//添加衣服
var strAddClothing = path+'/clothing/addClothing';
//获取所有衣服
var strQueryAllClothing = path+'/clothing/queryAllClothing';
//获取衣服对应歌姬
var strQueryClothingSinger = path+'/clothing/queryClothingSinger';

//获取选中位置的技能类型
var strGetSkillTypeByPos = path+'/skill/getSkillTypeByPos';
//添加技能
var strAddSkill = path +'/skill/addSkill';

//添加卡
var strAddCard = path + '/card/addCard';