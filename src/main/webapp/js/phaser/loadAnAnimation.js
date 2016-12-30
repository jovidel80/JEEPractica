/**
 * Created by joliveros on 29/12/2016.
 */
var game = new Phaser.Game(800, 600, Phaser.AUTO, 'image', {preload: preload, create: create});

function preload() {
    game.load.atlasJSONHash('bot', '../assets/phaser/loadAnAnimation/running_bot.png', '../assets/phaser/loadAnAnimation/running_bot.json')
}

function create() {
    var bot = game.add.sprite(200, 200, 'bot');
    bot.animations.add('correr');
    bot.animations.play('correr', 15, true);
}
