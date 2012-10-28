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


package grails.plugins.prettifyResources

import grails.util.Environment

import org.codehaus.groovy.grails.plugins.PluginManagerHolder

/**
 * @author Raanan Weber (raananw@gmail.com)
 */

class PrettifyTagLib {

	static final PLUGIN_NAME = "prettify-resources"

	static namespace = "prettify"

	def prettify = { attrs, body ->
		def lang = attrs.lang ? 'lang-'+attrs.lang : ""
		def lineNumbers = attrs.linenums ? 'linenums:' + attrs.linenums : ""
		out << '<pre class="prettyprint '+lang+' '+lineNumbers+'" >'
		out << body()
		out << '</pre>'
	}

	def runPrettify = { attrs ->

		if(attrs.event) {
			out << """
<script type="text/javascript">
window.addEventListener('${attrs.event}', function (event) { prettyPrint() }, false);
</script>
"""
		} else {
			out << """
<script type="text/javascript">
window.onload = function() {
		prettyPrint()
}
</script>
"""
		}
	}

	def resources = {  attrs ->
		// In production always use minified version
		String pluginVersion = PluginManagerHolder.pluginManager.getGrailsPlugin(this.PLUGIN_NAME).version
		def dev = grails.util.GrailsUtil.isDevelopmentEnv()
		def minified = (attrs.minified?:!dev);

		def basePath = "${request.contextPath}/plugins/${this.PLUGIN_NAME.toLowerCase()}-$pluginVersion"
		def jsDir = basePath + "/js" + (minified ? '/min' : '')
		def cssDir = basePath + "/css" + (minified ? '/min' : '')

		out << '<script src="${jsDir}/prettify.js"/>'
		out << '<link type="text/css" rel="stylesheet" href="${cssDir}/prettify.css"/>'

		attrs.aditionalLanguages?.each {
			out << '<script src="${jsDir}/lang-'+it+'.js"/>'
		}
	}

}
