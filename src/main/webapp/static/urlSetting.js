var path = 'http://localhost:8080/uta-macross';
//var path = 'http://kimirai7.w3.luyouxia.net/uta-macross';
//var path = 'http://192.168.2.164:8080/uta-macross';

var strLogin = path+'/view/login';
var strToMain = path+'/view/toMain';


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

//获取所有技能类型
var strGetSkillType = path +'/skill/getSkillType';
//获取选中位置的技能类型
var strGetSkillTypeByPos = path+'/skill/getSkillTypeByPos';
//根据类型获得技能
var strGetSkillByType = path +'/skill/getSkillByType';
//添加技能
var strAddSkill = path +'/skill/addSkill';

//添加卡
var strAddCard = path + '/card/addCard';




//以下为绑定相关
//获取一张没有绑定作品的卡
var strGetNoOpusCard = path+ '/bind/getNoOpusCard';
//绑定卡和作品
var strBindCardOpus = path + '/bind/cardOpus';

//获取一个没有绑定的飞机
var strGetNoOpusFighter = path+ '/bind/getFighter';
//绑定飞机和作品
var strBindFighterOpus = path + '/bind/fighterOpus';