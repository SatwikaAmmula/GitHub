"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
exports.__esModule = true;
exports.CreateApplicationComponent = void 0;
var core_1 = require("@angular/core");
var CreateApplicationComponent = /** @class */ (function () {
    function CreateApplicationComponent(service) {
        this.service = service;
    }
    CreateApplicationComponent.prototype.ngOnInit = function () {
    };
    CreateApplicationComponent.prototype.createNewLL = function (data) {
        this.service.applyForLL(data).subscribe(function (success) {
            console.log(success);
        }, function (fail) {
            console.log(fail);
        });
    };
    CreateApplicationComponent.prototype.createNewDL = function (data) {
        this.service.applyForDL(data).subscribe(function (success) {
            console.log(success);
        }, function (fail) {
            console.log(fail);
        });
    };
    CreateApplicationComponent = __decorate([
        core_1.Component({
            selector: 'app-create-application',
            templateUrl: './create-application.component.html',
            styleUrls: ['./create-application.component.css']
        })
    ], CreateApplicationComponent);
    return CreateApplicationComponent;
}());
exports.CreateApplicationComponent = CreateApplicationComponent;
