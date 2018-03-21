function appendToken() {
	updateForms();
	updateTags();
}

function updateForms() {
	// 得到页面中所有的 form 元素
	var forms = document.getElementsByTagName('form');
	for (i = 0; i < forms.length; i++) {
		var url = forms[i].action;
		// 如果这个 form 的 action 值为空，则不附加 csrftoken
		if (url == null || url == "") continue;
		// 动态生成 input 元素，加入到 form 之后
		var e = document.createElement("input");
		e.name = "csrftoken";
		e.value = token;
		e.type = "hidden";
		forms[i].appendChild(e);
	}
}

function updateTags() {
	var all = document.getElementsByTagName('a');
	var len = all.length;
	// 遍历所有 a 元素
	for (var i = 0; i < len; i++) {
		var e = all[i];
		updateTag(e, 'href', token);
	}
}

function updateTag(element, attr, token) {
	var location = element.getAttribute(attr);
	if (location != null && location != '') {
		var fragmentIndex = location.indexOf('#');
		var fragment = null;
		if (fragmentIndex != -1) {
			//url 中含有只相当页的锚标记
			fragment = location.substring(fragmentIndex);
			location = location.substring(0, fragmentIndex);
		}
		var index = location.indexOf('?');
		if (index != -1) {
			//url 中已含有其他参数
			location = location + '&csrftoken=' + token;
		} else {
			//url 中没有其他参数
			location = location + '?csrftoken=' + token;
		}
		if (fragment != null) {
			location += fragment;
		}
		element.setAttribute(attr, location);
	}
}