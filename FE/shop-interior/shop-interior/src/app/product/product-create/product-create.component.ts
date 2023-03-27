import {Component, Inject, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {AngularFireStorage} from "@angular/fire/storage";
import {finalize} from "rxjs/operators";
import {Router} from "@angular/router";
import {ProductService} from "../service/product.service";
import {formatDate} from "@angular/common";
import {Observable} from "rxjs";

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {
  productCreate = new FormGroup({
    imageOne: new FormControl(),
    imageTwo: new FormControl(),
    imageThree: new FormControl(),
    tan: new FormControl(),
  })
  private selectedFile: any= null;
  urlList :string[] = [];
  selectedImage: any[] = [];
  url: any;
  downloadURL: Observable<string> | undefined;
  src: string | undefined;
  constructor(private productService:ProductService,@Inject(AngularFireStorage) private storage: AngularFireStorage,private route: Router) { }

  ngOnInit(): void {
  }

  saveImage(): void {
    this.productCreate.patchValue({imageOne: this.urlList[0]});
    this.productCreate.patchValue({imageTwo: this.urlList[1]});
    this.productCreate.patchValue({imageThree: this.urlList[2]});
    this.productService.createProduct(this.productCreate.value).subscribe(() => {
      this.route.navigateByUrl('/home');
    });
  }

  showPreview(event: any): void {
    this.selectedImage = event.target.files;
    for (let i = 0; i < this.selectedImage.length; i++) {
      const filePath = this.selectedImage[i].name;
      const fileRef = this.storage.ref(filePath);
      const task = this.storage.upload(filePath, this.selectedImage[i]);
      task
        .snapshotChanges()
        .pipe(
          finalize(() => {
            this.downloadURL = fileRef.getDownloadURL();
            this.downloadURL.subscribe(url => {
              if (url) {
                this.urlList.push(url) ;

              }
              this.src = url;
            });
          })
        )
        .subscribe();
    }
  }
  getCurrentDateTime(): string {
    return formatDate(new Date(), 'dd-MM-yyyyhhmmssa', 'en-US');
  }
}
