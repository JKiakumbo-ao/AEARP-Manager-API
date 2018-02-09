
var SGestor = SGestor || {};

SGestor.PhotoUpload = (function() {
	
	function PhotoUpload() {
		this.inputPhotoName = $('input[name=photo]');
		this.inputContentType = $('input[name=contentType]');
		this.newPhoto = $('input[name=newPhoto]');
		
		this.htmlPersonPhotoTemplate = $('#person-photo').html();
		this.template = Handlebars.compile(this.htmlPersonPhotoTemplate)
		
		this.containerPersonPhoto = $('.js-container-person-photo');

		this.uploadDrop = $('#upload-drop');
	}
	
	PhotoUpload.prototype.begin = function () {
		var settings = {
			type: 'json',
			filelimit: 1,
			allow: '*.(jpg|jpeg|png)',
			action: this.containerPersonPhoto.data('url-photos'),
			complete: onUploadComplete.bind(this),
			beforeSend: addCsrfToken
		}
		
		UIkit.uploadSelect($('#upload-select'), settings);
		UIkit.uploadDrop(this.uploadDrop, settings);
		
		if (this.inputPhotoName.val()) {
			photoRender.call(this, { name:  this.inputPhotoName.val(), contentType: this.inputContentType.val()});
		}
	}
	
	function onUploadComplete(response) {
		this.newPhoto.val('true');
		photoRender.call(this, response);
	}
	
	function photoRender(response) {
		this.inputPhotoName.val(response.name);
		this.inputContentType.val(response.contentType);
		
		this.uploadDrop.addClass('hidden');
		
		var photo = '';
		if (this.newPhoto.val() == 'true') {
			photo = 'temp/';
		}
		photo += response.name;
		
		var htmlPersonPhoto = this.template({photo: photo});
		this.containerPersonPhoto.append(htmlPersonPhoto);
		
		$('.js-remove-photo').on('click', onRemovePhoto.bind(this));
	}
	
	function onRemovePhoto() {
		$('.js-person-photo').remove();
		this.uploadDrop.removeClass('hidden');
		this.inputPhotoName.val('');
		this.inputContentType.val('');
		this.newPhoto.val('false');
	}
	
	function addCsrfToken(xhr) {
		var token = $('input[name=_csrf]').val();
		var header = $('input[name=_csrf_header]').val();
		xhr.setRequestHeader(header, token);
	}
	
	return PhotoUpload;
	
})();

$(function() {
	var photoUpload = new SGestor.PhotoUpload();
	photoUpload.begin();
});
