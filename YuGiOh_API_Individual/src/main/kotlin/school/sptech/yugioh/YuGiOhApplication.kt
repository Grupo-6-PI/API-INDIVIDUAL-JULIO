package school.sptech.yugioh

import org.modelmapper.ModelMapper
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
@SpringBootApplication
class YuGiOhApplication {
	@Bean
	fun modelMapper(): ModelMapper {
		val modelMapper = ModelMapper()
		modelMapper.configuration
			.setFieldMatchingEnabled(true)
			.setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
		return modelMapper
	}
}

fun main(args: Array<String>) {
	runApplication<YuGiOhApplication>(*args)
}
