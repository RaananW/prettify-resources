// Copyright (C) 2012 Raanan Weber.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

//TODO currently unused.
def log = org.apache.log4j.Logger.getLogger('grails.plugins.prettifyResources')

def dev = grails.util.GrailsUtil.isDevelopmentEnv()

def jsDir = dev ? "js" : "js/min"
def cssDir = dev ? "css" : "css/min"

//was created to make the definition of pretti-* a little easier, but it was working. Leaving for now.
def langList = ['clj','css','go','hs','lisp','lua','ml','n','proto','scala','sql','tex','vb','vhdl','wiki','xq','yaml']
def langDependencies = langList.collect { lang-> 'prettify-'+lang }

modules = {
	'prettify' {
		resource url:[plugin: 'prettify', dir: jsDir, file: 'prettify.js'], disposition: 'head', exclude:'minify'
		resource url:[plugin: 'prettify', dir: cssDir, file: 'prettify.css'], disposition: 'head', exclude:'minify'
	}
	
	//TODO is there a "groovier" way to do this?
	
	'prettify-clj' {
		dependsOn 'prettify'
		
		resource url:[plugin: 'prettify', dir: jsDir, file: 'lang-clj.js'], disposition: 'head', exclude:'minify'
	}
	
	'prettify-css' {
		dependsOn 'prettify'
		
		resource url:[plugin: 'prettify', dir: jsDir, file: 'lang-css.js'], disposition: 'head', exclude:'minify'
	}
	
	'prettify-go' {
		dependsOn 'prettify'
		
		resource url:[plugin: 'prettify', dir: jsDir, file: 'lang-go.js'], disposition: 'head', exclude:'minify'
	}
	
	'prettify-hs' {
		dependsOn 'prettify'
		
		resource url:[plugin: 'prettify', dir: jsDir, file: 'lang-hs.js'], disposition: 'head', exclude:'minify'
	}
	
	'prettify-lisp' {
		dependsOn 'prettify'
		
		resource url:[plugin: 'prettify', dir: jsDir, file: 'lang-lisp.js'], disposition: 'head', exclude:'minify'
	}
	
	'prettify-lua' {
		dependsOn 'prettify'
		resource url:[plugin: 'prettify', dir: jsDir, file: 'lang-lua.js'], disposition: 'head', exclude:'minify'
	}
	
	'prettify-ml' {
		dependsOn 'prettify'
		resource url:[plugin: 'prettify', dir: jsDir, file: 'lang-ml.js'], disposition: 'head', exclude:'minify'
	}
	
	'prettify-n' {
		dependsOn 'prettify'
		resource url:[plugin: 'prettify', dir: jsDir, file: 'lang-n.js'], disposition: 'head', exclude:'minify'
	}
	
	'prettify-sql' {
		dependsOn 'prettify'
		resource url:[plugin: 'prettify', dir: jsDir, file: 'lang-sql.js'], disposition: 'head', exclude:'minify'
	}
	
	'prettify-tex' {
		dependsOn 'prettify'
		resource url:[plugin: 'prettify', dir: jsDir, file: 'lang-tex.js'], disposition: 'head', exclude:'minify'
	}
	
	'prettify-vb' {
		dependsOn 'prettify'
		resource url:[plugin: 'prettify', dir: jsDir, file: 'lang-vb.js'], disposition: 'head', exclude:'minify'
	}
	
	'prettify-proto' {
		dependsOn 'prettify'
		resource url:[plugin: 'prettify', dir: jsDir, file: 'lang-proto.js'], disposition: 'head', exclude:'minify'
	}
	
	'prettify-scala' {
		dependsOn 'prettify'
		resource url:[plugin: 'prettify', dir: jsDir, file: 'lang-scala.js'], disposition: 'head', exclude:'minify'
	}
	
	'prettify-vhdl' {
		dependsOn 'prettify'
		resource url:[plugin: 'prettify', dir: jsDir, file: 'lang-vhdl.js'], disposition: 'head', exclude:'minify'
	}
	
	'prettify-wiki' {
		dependsOn 'prettify'
		resource url:[plugin: 'prettify', dir: jsDir, file: 'lang-wiki.js'], disposition: 'head', exclude:'minify'
	}
	
	'prettify-xq' {
		dependsOn 'prettify'
		resource url:[plugin: 'prettify', dir: jsDir, file: 'lang-xq.js'], disposition: 'head', exclude:'minify'
	}
	
	'prettify-yaml' {
		dependsOn 'prettify'
		resource url:[plugin: 'prettify', dir: jsDir, file: 'lang-yaml.js'], disposition: 'head', exclude:'minify'
	}
	
	'prettify-all' {
		//TODO does this work?!?!?!
		dependsOn 'prettify' 
		dependsOn langDependencies
		
	}
}