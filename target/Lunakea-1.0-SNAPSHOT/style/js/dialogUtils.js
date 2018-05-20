function GDV_DialogUtil(){
    
    //affichage de fenêtre de dialogue
    this.showDialog = function(element, config){		
		var dialogObject = element.dialog({
			hide: (config.hide) ? config.hide : null,
	        show: (config.show) ? config.show : null,
			position: config.position,
			modal: (config.modal),
			draggable: (config.draggable),
			resizable: (config.resizable),
			dialogClass: config.dialogClass,
			minHeight: (config.minHeight) ? config.minHeight : 0,
			minWidth: (config.minWidth) ? config.minWidth : 0,
			closeOnEscape: (config.closeOnEscape),
			buttons: config.buttons,
			open: config.openCallback
		});
		
		if (config.displayTime && config.displayTime > 0){
			setTimeout(function(){
				dialogObject.dialog( "close" );
			}, config.displayTime);
		}
		
		return dialogObject;
	};
        
    //Affichage d'un message d'attente
    this.showWaiting = function(informationMessage, config){
		var dialogId = "dialog-waiting";
		
		var isModal = (config != null && config.modal != null && config.modal == true);
		
		//get div pour dialog
		var $divDialog = $( "#" + dialogId );
		
		//Si div pour dialog n'existe pas encore
		if ($divDialog.length == 0){
			//ajout d'une div dans le body de la fenêtre dialog
			$divDialog = $("<div />").appendTo("body");
			$divDialog.attr("id", dialogId);
		}
		
		//suppression du titre
		$divDialog.removeAttr("title");
		
		//suppression du contenu
		$divDialog.empty();
		
		//ajout du nouveau contenu
		$divDialog.append(informationMessage);
		
		//affichage de la fenêtre dialog
		var dialogObject = this.showDialog($divDialog, {
			modal: isModal,
			draggable: false,
			resizable: false,
			dialogClass: "dialog-waiting",
			minHeight: 0,
			closeOnEscape: false,
			buttons: [ ]
		});
		
		return dialogObject;
	};
    
    //Affichage d'un message de réussite
    this.showSuccess = function(title, informationMessage, config){
		var dialogId = "dialog-message";
		
		var isModal = (config != null && config.modal != null && config.modal == true);
		
		//get div pour dialog
		var $divDialog = $( "#" + dialogId );
		
		//Si div pour dialog n'existe pas encore
		if ($divDialog.length == 0){
			//ajout d'une div dans le body de la fenêtre dialog
			$divDialog = $("<div />").appendTo("body");
			$divDialog.attr("id", dialogId);
		}
		
		//modification du titre
		$divDialog.attr("title", title);
		
		//suppression du contenu
		$divDialog.empty();
		
		//ajout du nouveau contenu
		$divDialog.append(informationMessage);
		
		//affichage de la fenêtre dialog
		var dialogObject = this.showDialog($divDialog, {
			displayTime: config.displayTime,
			hide: config.hide,
			show: config.show,
			modal: isModal,
			draggable: false,
			resizable: false,
			dialogClass: "dialog-success",
			minHeight: 0,
			closeOnEscape: false,
			buttons: [ ]
		});
		
		return dialogObject;
	};
    
    //Affichage d'un message d'erreur
    this.showError = function (title, message, config) {
        var dialogId = "dialog-error";

        var isModal = (config != null && config.modal != null && config.modal == true);
        var buttonLabel = (config != null && config.buttonLabel != null && config.buttonLabel != "") ? config.buttonLabel : "Ok";

        //get div pour dialog
        var $divDialog = $("#" + dialogId);

        //Si div pour dialog n'existe pas encore
        if ($divDialog.length == 0) {
            //ajout d'une div dans le body de la fenêtre dialog
            $divDialog = $("<div />").appendTo("body");
            $divDialog.attr("id", dialogId);
        }

        //modification du titre
        $divDialog.attr("title", title);

        //suppression du contenu
        $divDialog.empty();

        //ajout du nouveau contenu
        $divDialog.append(message);

        //affichage de la fenêtre dialog
        var dialogObject = this.showDialog($divDialog, {
            modal: isModal,
            draggable: false,
            resizable: false,
            dialogClass: "dialog-error",
            minHeight: 0,
            closeOnEscape: false,
            buttons: [{text: buttonLabel, click: function () {
                        $(this).dialog("close");
                    }}]
        });

        return dialogObject;
    };
};

var GdvDialogUtil = new GDV_DialogUtil();

