var baseConfig = require('./karma.conf.js');

module.exports = function(config) {
	baseConfig(config);

	config.set({
		browsers : [ 'PhantomJS' ],
		reporters : [ 'junit' ],
		singleRun : true,
		autoWatch : false
	}) 
}