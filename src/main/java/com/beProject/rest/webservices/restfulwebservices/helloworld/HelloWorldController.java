package com.beProject.rest.webservices.restfulwebservices.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

//Controller
@RestController()
//@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(path = "image")
public class HelloWorldController {
	String Hash="genesis";
	@Autowired
	ImageRepository imageRepository;
	/*@CrossOrigin(origins = "http://localhost:8100")
	@PostMapping("/upload")
	public ResponseEntity.BodyBuilder uplaodImage(@RequestParam("imageFile") MultipartFile file) throws IOException {

		System.out.println("Original Image Byte Size - " + file.getBytes().length);

		ImageModel img = new ImageModel(file.getOriginalFilename(), file.getContentType(),

				compressBytes(file.getBytes()));

		imageRepository.save(img);


		return ResponseEntity.status(HttpStatus.OK);

	}*/


	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/get/{imageName}")
	public ImageModel getImage(@PathVariable("imageName") String imageName) throws IOException {

		final Optional<ImageModel> retrievedImage = imageRepository.findBypreHash(Hash);

		ImageModel img = new ImageModel(retrievedImage.get().getName(), retrievedImage.get().getType(),decompressBytes(retrievedImage.get().getPicByte()),retrievedImage.get().getPreHash(),retrievedImage.get().getNewHash(),retrievedImage.get().getNodeid(),retrievedImage.get().getSensor());
		Hash=retrievedImage.get().getNewHash();
		return img;

	}
	/*public static byte[] compressBytes(byte[] data) {

		Deflater deflater = new Deflater();

		deflater.setInput(data);
		deflater.finish();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);

		byte[] buffer = new byte[1024];

		while (!deflater.finished()) {

			int count = deflater.deflate(buffer);

			outputStream.write(buffer, 0, count);


		}

		try {
			outputStream.close();

		} catch (IOException e) {
		}
		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

		return outputStream.toByteArray();


	}*/
	public static byte[] decompressBytes(byte[] data) {

		Inflater inflater = new Inflater();

		inflater.setInput(data);

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);

		byte[] buffer = new byte[1024];

		try {

			while (!inflater.finished()) {

				int count = inflater.inflate(buffer);

				outputStream.write(buffer, 0, count);

			}

			outputStream.close();

		} catch (IOException ioe) {

		} catch (DataFormatException e) {

		}

		return outputStream.toByteArray();

	}

}
